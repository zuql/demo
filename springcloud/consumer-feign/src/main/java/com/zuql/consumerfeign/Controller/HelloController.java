package com.zuql.consumerfeign.Controller;

import com.zuql.consumerfeign.client.EurekaServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController  {

    @Autowired
    public EurekaServiceFeign eurekaServiceFeign;

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
         return  eurekaServiceFeign.hello(name);
    }
}
