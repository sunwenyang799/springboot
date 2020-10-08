package com.springboot.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:05 2020/9/27
 * @ Description：定制springmvc配置
 */
@Configuration
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    //为容器冲添加一个ViewControllers
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addView").setViewName("success");
    }
}
