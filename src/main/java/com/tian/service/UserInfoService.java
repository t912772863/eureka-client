package com.tian.service;

import com.tian.dao.entity.UserInfo;
import com.tian.dao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public void insert(UserInfo userInfo){
        userInfo.setCreateTime(new Date());
        userInfoMapper.insertSelective(userInfo);
    }

    public UserInfo queryByMobile(String mobile){
        return userInfoMapper.queryByMobile(mobile);
    }

    public UserInfo queryById(Long id){
        return userInfoMapper.selectByPrimaryKey(id);
    }

}
