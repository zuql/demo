package com.zuql.demo.springbootssmmybatisplus.user.controller;


import com.zuql.demo.springbootssmmybatisplus.user.pojo.User;
import com.zuql.demo.springbootssmmybatisplus.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCotroller {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/find/{name}")
    public List<User> find(User user){
        return userService.find(user);
    }

    @RequestMapping("insert/{name}/{birthday}/{address}")
    public String insert(User user){
        try{
            userService.insert(user);
            return "1 insert success.";
        }catch(Exception e){
            e.printStackTrace();
            return "1 insert error.";
        }
    }

    @RequestMapping("/update") //转换成json方式，接参
    public String update(@RequestBody User user){
        try{
            userService.update(user);
            return "1 update success.";
        }catch(Exception e){
            e.printStackTrace();
            return "1 update error.";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        try{
            userService.delete(id);
            return "1 delete success";
        }catch(Exception e){
            e.printStackTrace();
            return "1 delete error";
        }
    }

}
