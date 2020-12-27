package com.springboot.controller;

import com.springboot.entity.Department;
import com.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swy
 * @description:
 * @date 2020/12/3 10:43
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RedisTemplate deptRedisTemplate;

    @GetMapping("/dept/{id}")
     public Department getDeptById(@PathVariable("id") Integer id){
         return departmentService.getDeptById(id);
     }

     @GetMapping("/dept/redis/{id}")
    public Department getDeptByIdByRedis(@PathVariable("id") Integer id){
        return (Department) deptRedisTemplate.opsForValue().get("dept::"+id);
    }
}
