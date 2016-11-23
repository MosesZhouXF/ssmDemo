package com.moses.service.impl;

import com.moses.dto.LoginResult;
import com.moses.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-11-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class LoginServiceImplTest {
    @Autowired
    private LoginService loginService;
    @Test
    public void doLogin() throws Exception {
        LoginResult loginResult = loginService.doLogin("2","2");
        System.out.println(loginResult);
    }

}