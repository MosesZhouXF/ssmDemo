package com.moses.enums;

/**
 * Created by Administrator on 2016-11-22.
 */
public enum LoginResultState {
    SUCCESS(1,"登录成功"),
    INNER_ERROR(2,"系统异常"),
    USER_IS_NOT_EXIST(3,"用户不存在"),
    INCORRECT_PASSWORD(4,"密码不正确");

    private int state;
    private String stateInfo;

    LoginResultState(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static LoginResultState stateOf(int index) {
        for(LoginResultState state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
