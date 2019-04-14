package com.zuql.demo.springbootssmmybatisplus.user.service;



import com.zuql.demo.springbootssmmybatisplus.user.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public List<User> find(User user);
    public void insert(User user);
    public void update(User user);
    public void delete(Integer id);
}
