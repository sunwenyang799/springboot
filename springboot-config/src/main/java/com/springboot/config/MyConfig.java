package com.springboot.config;

import com.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author swy
 * @description: ioc容器
 * @date 2020/9/23 15:09
 */
@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
