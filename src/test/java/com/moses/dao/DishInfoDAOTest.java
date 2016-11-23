package com.moses.dao;

import com.moses.pojo.DishInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-11-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class DishInfoDAOTest {
    @Resource
    private DishInfoDAO dishInfoDAO;

    @Test
    public void getDishInfoById() throws Exception {
        DishInfo dishInfo = dishInfoDAO.getDishInfoById(1);
        System.out.println(dishInfo.getdName());
    }

}