package com.moses.dto;

import com.moses.enums.LoginResultState;
import com.moses.pojo.UserInfo;

/**
 * Created by Administrator on 2016-11-22.
 */
public class LoginResult {
    private int state;
    private String stateInfo;
    private UserInfo userInfo;

    public LoginResult(LoginResultState loginResultState, UserInfo userInfo) {
        this.state = loginResultState.getState();
        this.stateInfo = loginResultState.getStateInfo();
        this.userInfo = userInfo;
    }

    public LoginResult(LoginResultState loginResultState) {
        this.state = loginResultState.getState();
        this.stateInfo = loginResultState.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
