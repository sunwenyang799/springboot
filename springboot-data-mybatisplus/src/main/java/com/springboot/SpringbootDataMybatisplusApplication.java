package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
@MapperScan(value = "com.springboot.mapper")
public class SpringbootDataMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataMybatisplusApplication.class, args);
    }

}
