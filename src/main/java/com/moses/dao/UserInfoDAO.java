package com.moses.dao;

import com.moses.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016-11-22.
 */
public interface UserInfoDAO {

    UserInfo getUserInfoById(String userId);

    int vaildateUserInfo(@Param("userId") String userId, @Param("password") String password);

}
