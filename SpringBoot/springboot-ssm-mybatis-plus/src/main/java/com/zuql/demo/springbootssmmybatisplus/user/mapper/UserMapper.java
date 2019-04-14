package com.zuql.demo.springbootssmmybatisplus.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zuql.demo.springbootssmmybatisplus.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解和xml方式混合
//使用MP后，继承BaseMapper接口，实现单表CRUD SQL语句
public interface UserMapper extends BaseMapper<User> {


}
