package com.zuql.provideruser.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "user:"+name;
    }

}
