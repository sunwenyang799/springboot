package com.springboot.com.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:05 2020/9/27
 * @ Description：定制springmvc配置   2.0以后extends WebMvcConfigurationSupport 全面接管mvc 相当于加@EnableWebMvc
 */
//@Configuration
public class EnableMyMvcConfig extends WebMvcConfigurationSupport {

    //为容器冲添加一个ViewControllers
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addView").setViewName("success");
    }
}
