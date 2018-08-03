package com.tian.dao.mapper;

import com.tian.dao.entity.UserInfo;
import feign.Param;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 根据手机号查询用户信息
     * @param mobile
     * @return
     */
    UserInfo queryByMobile(@Param("mobile") String mobile);
}