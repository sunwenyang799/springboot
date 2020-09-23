package com.springboot;

import com.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Springboot02ConfigApplicationTests {
    
    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ioc;
    @Test

    void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testImportResource(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

}
