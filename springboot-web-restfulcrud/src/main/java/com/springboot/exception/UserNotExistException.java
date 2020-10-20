package com.springboot.exception;

/**
 * @author swy
 * @description: 自定义异常
 * @date 2020/10/16 13:46
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
