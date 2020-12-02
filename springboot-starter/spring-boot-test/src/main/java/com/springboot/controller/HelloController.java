package com.springboot.controller;

import com.springboot.autoconfiguration.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swy
 * @description:
 * @date 2020/11/26 17:22
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return  helloService.say("小明");
    }
}
