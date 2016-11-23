package com.moses.service.impl;

import com.moses.dao.UserInfoDAO;
import com.moses.dto.LoginResult;
import com.moses.enums.LoginResultState;
import com.moses.pojo.UserInfo;
import com.moses.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016-11-22.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    public LoginResult doLogin(String userId, String password) {
        UserInfo userInfo = userInfoDAO.getUserInfoById(userId);
        try {
            if(userInfo == null){
                return new LoginResult(LoginResultState.USER_IS_NOT_EXIST);
            }else{
                int state = userInfoDAO.vaildateUserInfo(userId, password);
                if(state == 1){
                    return new LoginResult(LoginResultState.SUCCESS, userInfo);
                }else if(state == 0){
                    return new LoginResult(LoginResultState.INCORRECT_PASSWORD);
                }
            }
        }catch (Exception e){
            return new LoginResult(LoginResultState.INNER_ERROR);
        }

        return new LoginResult(LoginResultState.INNER_ERROR);
    }
}
