package com.tian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
@RestController
public class DcController {

    /**
     * 可以通过discovery对象获服务注册的一些信息
     */
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        // 这里加一个休眠时间, 用来演示由于服务响应缓慢, 实现 服务降级处理
        if(new Random().nextInt(5)>2){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(services);
        return services;
    }

    @GetMapping("/dc2")
    public String dc2(){
        return "Services: " + discoveryClient.getServices();
    }
}
