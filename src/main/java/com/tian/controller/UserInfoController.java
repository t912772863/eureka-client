package com.tian.controller;

import com.tian.common.other.BusinessException;
import com.tian.common.other.ResponseData;
import com.tian.dao.entity.TestEntity;
import com.tian.dao.entity.UserInfo;
import com.tian.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
@Api("用户信息管理")
@RestController
@RequestMapping("userInfo")
public class UserInfoController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 注册的时候, 发送手机验证码
     * @param mobile
     * @return
     */
    @ApiOperation("注册的时候, 发送手机验证码")
    @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "String")
    @RequestMapping("/sendMsg/{mobile}")
    public ResponseData sendMsg(@PathVariable String mobile) {
        // TODO: 2018/8/2 0002 实际业务中, 这里取随机6位数字验证码 
        String code = "111111";
        // TODO: 2018/8/2 0002 实际业务中, 这里调第三方短信接口下发短信
        log.info("您正在注册暴鸡电竞, 注册码为: {}.", code);
        redisTemplate.opsForValue().set(mobile, code, 5*60, TimeUnit.SECONDS);
        log.info("从redis中获取到手机号:"+mobile+"的验证码为: "+redisTemplate.opsForValue().get(mobile));

        return SUCCESS_RESPONSE;
    }

    /**
     * 注册的时候验证手机验证码
     * @param mobile
     * @param code
     * @return
     */
    @RequestMapping("/register/{mobile}/{code}")
    public ResponseData register(@PathVariable String mobile, @PathVariable String code){
        UserInfo userInfo = userInfoService.queryByMobile(mobile);
        if(userInfo != null){
            throw new BusinessException(500, "手机号已经注册");
        }
        String saveCode = (String)redisTemplate.opsForValue().get(mobile);
        if(!code.equals(saveCode)){
            throw new BusinessException(500, "验证码有误");
        }
        return SUCCESS_RESPONSE;
    }

    /**
     * 手机验证码登录
     * @param mobile
     * @param code
     * @return
     */
    @RequestMapping("login/{mobile}/{code}")
    public ResponseData login(@PathVariable String mobile, @PathVariable String code){
        String saveCode = (String)redisTemplate.opsForValue().get(mobile);
        if(!code.equals(saveCode)){
            throw new BusinessException(500, "验证码不对");
        }
        UserInfo userInfo = userInfoService.queryByMobile(mobile);
        // 登录成功, 保存Session, Token等
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token, userInfo, 60, TimeUnit.MINUTES);
        return SUCCESS_RESPONSE;
    }

    /**
     * 获取当前用户信息
     * @param request
     * @return
     */
    @RequestMapping("getUserInfo")
    public ResponseData getUserInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(token);
        return SUCCESS_RESPONSE.setData(userInfo);
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/queryById/{id}")
    public ResponseData queryById(@PathVariable Long id){
        return SUCCESS_RESPONSE.setData(userInfoService.queryById(id));
    }

    /**
     * 新增一条用户信息
     * @param userInfo
     * @return
     */
    @PostMapping("/insert")
    public ResponseData insert(@RequestBody UserInfo userInfo){
        userInfoService.insert(userInfo);

        return SUCCESS_RESPONSE;
    }

    @RequestMapping("/queryById2/{id}")
    public TestEntity queryById2(@PathVariable Long id){
        TestEntity entity = new TestEntity();
        entity.setIntValue(100);
        entity.setStringValue("I am String.");
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        entity.setListValue(list);
        return entity;
    }

    @RequestMapping(value = "/queryById3/{id}", method = RequestMethod.POST)
    public ResponseData queryById3(@PathVariable Long id, String a, @RequestBody TestEntity testEntity){
        return SUCCESS_RESPONSE.setData(userInfoService.queryById(id));
    }


}
