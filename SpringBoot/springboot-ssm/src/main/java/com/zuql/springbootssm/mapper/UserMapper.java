package com.zuql.springbootssm.mapper;

import com.zuql.springbootssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解和xml方式混合
@Repository
public interface UserMapper {

    public List<User> findAll();
    @Select("select name,birthday,addRess from user where id=#{id}")
    public User get(@Param("id") int id);
}
