package com.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 15:25 2020/12/27
 * @ Description：
 */
@Service
public class AsyncService {
    @Async
    public  void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("你好");
    }
}
