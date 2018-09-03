package com.yht;

import com.yht.dao.UserDao;
import com.yht.domain.User;
import com.yht.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * 2018/9/2 17:56
 **/
public class DemoTest {

    @Test
    public void testSpring() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:sping-mybatis.xml");
        UserDao userDao= (UserDao) context.getBean("userDao");
        System.out.println(userDao.selectById(1));
    }
}
