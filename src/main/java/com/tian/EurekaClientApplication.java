package com.tian;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tian.common.handler.DefaultExceptionHandler;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.text.SimpleDateFormat;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * 创建一个服务提供方示例.
 *
 *  加上@EnableDiscoveryClient, 则会把本服务注册到注册中心
 *
 */
@MapperScan("com.tian.dao")
//@EnableFeignClients
//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {

	/**
	 * 显式定义这个bean,修改属性,使得可以格式化返回的时间格式,空属性等
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		MappingJackson2HttpMessageConverter m = new MappingJackson2HttpMessageConverter();
		ObjectMapper o = new ObjectMapper();
		o.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		o.setSerializationInclusion(NON_NULL);
		m.setObjectMapper(o);
		return m;
	}
	/**
	 * 全局异常处理器
	 * @return
	 */
	@Bean
	public HandlerExceptionResolver exceptionHandler(){
		return new DefaultExceptionHandler();
	}

	@Bean
	public ActiveMQConnectionFactory jmsConnectionFactory(){
		return new ActiveMQConnectionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
