package com.yht;

import com.yht.dao.UserDao;
import com.yht.dao.UserDao2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 2018/9/2 17:56
 **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class DemoTest {

    @Test
    public void testSpring() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        UserDao userDao= (UserDao) context.getBean("userDao");
        System.out.println(userDao.selectById(1));
        UserDao2 userDao2= (UserDao2) context.getBean("userDao2");
        System.out.println(userDao2.selectById(1));
    }
}
