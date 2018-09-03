package com.yht.dao;

import com.yht.domain.User;
import com.yht.mapper.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingdee on 2018/9/3.
 */
public class UserDao {
    private static String NAMESPACE = "com.yht.mapper.UserMapper";
//    @Autowired
//    UserMapper userMapper;
    @Autowired
    SqlSessionTemplate sessionTemplate;
    public User selectById(int id) {
//        User user = userMapper.selectById(id);
        User user =sessionTemplate.selectOne(NAMESPACE+".selectById",id);
        return user;
    }
}
