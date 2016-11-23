package com.moses.dao;

import com.moses.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-11-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserInfoDAOTest {

    @Resource
    private UserInfoDAO userInfoDAO;

    @Test
    public void getUserInfoById() throws Exception {
        UserInfo userInfo = userInfoDAO.getUserInfoById("1");
        System.out.println(userInfo);
    }

    @Test
    public void vaildateUserInfo() throws Exception {
        int flag = userInfoDAO.vaildateUserInfo("1","2");
        System.out.println(flag);
    }

}