package com.zuql.springbootssm.service;

import com.zuql.springbootssm.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User get(int id);
}
