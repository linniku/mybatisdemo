package com.yht.dao;

import com.yht.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingdee on 2018/9/3.
 */
public class UserDao {
    private static String NAMESPACE = "com.tianshouzhi.zebracost.UserMapper";
    @Autowired
    SqlSessionTemplate sqlSession;
    public User selectById(int id) {
        User user = sqlSession.selectOne(NAMESPACE + ".selectById",id);
        return user;
    }
}
