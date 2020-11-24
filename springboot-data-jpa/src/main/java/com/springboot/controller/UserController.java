package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:31 2020/11/24
 * @ Description：
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id")Integer id){
        return userMapper.getOne(id);
    }

    @GetMapping("/user")
    public User saveUser(User user){
        return userMapper.save(user);
    }
}
