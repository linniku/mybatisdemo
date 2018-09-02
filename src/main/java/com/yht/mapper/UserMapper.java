package com.yht.mapper;

import com.yht.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 2018/9/2 18:00
 **/
public interface UserMapper {
//    @Insert("INSERT INTO user(id,name,age) VALUES (#{id},#{name},#{age})")
    public int insert(User user);
//    @Select(" select id,name,age from user where id= #{id}")
    public User selectById(int id);
//    @Select(" select id,name,age from user")
    public List<User> selectAll();
//    @Update("UPDATE user SET name=#{name},age=#{age} WHERE id=#{id}")
    public int updateById(User user);
//    @Delete("DELETE FROM user WHERE id=#{id}")
    public int deleteById(int id);
//    @Delete("DELETE FROM user")
    public int deleteAll();
}
