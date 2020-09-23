package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
/**
 * @ImportResource 引入组件,如果是xml使用注解引入,如果是类,将类变为配置类 @Configuration
 */
//@ImportResource(locations = "classpath:beans.xml")
public class Springboot02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02ConfigApplication.class, args);
    }

}
