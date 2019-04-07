package com.zuql.sb.demo;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    public String hello(String name){
        return "SpringBoot:"+name;
    }
}
