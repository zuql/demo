package com.zuql.consumerclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloConller {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
           String url="http://localhost:7900/hello/"+name;
        url="http://provider-user/hello/"+name;
           return this.restTemplate.getForObject(url,String.class);
    }
}
