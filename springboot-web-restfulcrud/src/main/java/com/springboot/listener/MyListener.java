package com.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:48 2020/10/20
 * @ Description：自定义监听器
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("myListener process...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("myListener destory...");
    }
}
