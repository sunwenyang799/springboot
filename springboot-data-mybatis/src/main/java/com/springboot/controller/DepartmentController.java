package com.springboot.controller;

import com.springboot.mapper.DepartmentMapper;
import com.springboot.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:02 2020/11/23
 * @ Description：
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department addDept(Department department){
        departmentMapper.addDept(department);
        return  department;
    }
}
