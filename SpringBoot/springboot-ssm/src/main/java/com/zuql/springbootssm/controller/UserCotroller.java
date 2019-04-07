package com.zuql.springbootssm.controller;

import com.zuql.springbootssm.pojo.User;
import com.zuql.springbootssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCotroller {
    @Autowired
    private UserService userService;
    @RequestMapping("/finAll")
    public List<User> findAll() {
        return userService.findAll();
    }
    @RequestMapping("/get/{id}")
    public User get(@PathVariable int id) {
        return userService.get(id);
    }
}
