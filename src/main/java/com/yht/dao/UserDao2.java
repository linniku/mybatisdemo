package com.yht.dao;

import com.yht.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingdee on 2018/9/3.
 */
public class UserDao2 extends SqlSessionDaoSupport{
    private static String NAMESPACE = "com.yht.mapper.UserMapper";
    public User selectById(int id) {
        User user =getSqlSession().selectOne(NAMESPACE+".selectById",id);
        return user;
    }
}
