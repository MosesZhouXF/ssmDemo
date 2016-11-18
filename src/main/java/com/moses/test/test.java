package com.moses.test;

import com.moses.dao.DishInfoDAO;
import com.moses.pojo.DishInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016-11-17.
 */
public class test {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            DishInfo dishInfo = session.getMapper(DishInfoDAO.class).getDishInfoById(1);
            System.out.println(dishInfo.getdName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
