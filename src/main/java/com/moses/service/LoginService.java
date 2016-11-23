package com.moses.service;

import com.moses.dto.LoginResult;

/**
 * Created by Administrator on 2016-11-22.
 */
public interface LoginService {
    LoginResult doLogin(String userId,String password);
}
