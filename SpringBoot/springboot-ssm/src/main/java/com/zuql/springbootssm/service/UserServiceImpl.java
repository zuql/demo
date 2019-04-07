package com.zuql.springbootssm.service;

import com.zuql.springbootssm.mapper.UserMapper;
import com.zuql.springbootssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }
    public User get(int id){
        return userMapper.get(id);
    }
}
