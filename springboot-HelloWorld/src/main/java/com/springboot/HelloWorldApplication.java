package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 16:26 2020/9/20
 * @ Description：
 */

/**
 * @SpringBootApplication来标注一个主程序类，说明这个一个springboot应用
 */
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args){
        SpringApplication.run(HelloWorldApplication.class,args);
    }
}
