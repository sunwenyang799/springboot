package com.springboot;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:54 2020/10/20
 * @ Description：
 */
public class Son  extends Father{

    @Override
    public void say() {
        System.out.println("子类say");
    }
}
