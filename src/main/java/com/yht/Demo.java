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

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * 2018/9/2 17:56
 **/
public class Demo {
    public  static  SqlSessionFactory sqlSessionFactory;
    public static String namespace="com.yht.mapper.UserMapper";
    public static SqlSession sqlSession;
    @BeforeClass
    public static void testBefore() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Before
    public  void before(){
        sqlSession=sqlSessionFactory.openSession();
    }

    @Test
    public void testInsert(){
        User user1 = new User();
        user1.setId(1);
        user1.setName("tianshouzhi");
        user1.setAge(27);
        User user2 = new User();
        user2.setId(2);
        user2.setName("wangxiaoxiao");
        user2.setAge(26);
        String statement = namespace + ".insert";
        sqlSession.insert(statement,user1);
        sqlSession.insert(statement,user2);

    }

    // 测试查询单条记录，调用sqlSession的selectOne方法
    @Test
    public void testSelectOne() {
        String statement = namespace + ".selectById";
        User user=sqlSession.selectOne(statement,1);
        System.out.println(user);
    }

    @Test
    public void testSelectAll() {
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectAll());
    }

    @Test
    public void testInsertAuto() {
        User user = new User();
        user.setName("tianshouzhi2");
        user.setAge(28);
        System.out.println("插入前 id:" + user.getId());
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.insert(user);
        System.out.println("插入后：" + user.getId());
    }

    // 每个单元测试方法(添加@Test注解的方法)在执行后，此方法都会被juint框架回调，关闭SqlSession实例
    @After
    public void after() {
        sqlSession.close();
    }
}
