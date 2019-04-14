package com.zuql.demo.springbootssmmybatisplus.user.service;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zuql.demo.springbootssmmybatisplus.user.mapper.UserMapper;
import com.zuql.demo.springbootssmmybatisplus.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    //查询所有
    public List<User> findAll(){
        return userMapper.selectList(null);
    }
    //带条件查询 EntityWrapper
    public List<User> find(User user){
        //封装where条件
        EntityWrapper wrapper = new EntityWrapper();
        //封装对象里面写的都是数据库的字段名称user_name
        //QBC面向对象
        wrapper.like("name", user.getName());	// name like '%tony%'

        return userMapper.selectList(wrapper);
    }

    //新增
    public void insert(User user){
        userMapper.insert(user);
    }

    //修改
    public void update(User user){
        userMapper.updateById(user);
    }

    //删除
    public void delete(Integer id){
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(id);

        //批量删除
        userMapper.deleteBatchIds(idList);
    }

}
