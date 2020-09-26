package com.springboot.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 16:37 2020/9/26
 * @ Description：
 */
@Controller
public class HelloController {

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //public static final String DEFAULT_PREFIX = "classpath:/templates/";
        //public static final String DEFAULT_SUFFIX = ".html";
        map.put("hello","你好！");
        map.put("success","成功了...");
        map.put("hello1","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
