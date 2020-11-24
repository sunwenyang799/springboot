package com.springboot.controller;

import com.springboot.mapper.EmployeeMapper;
import com.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 19:53 2020/11/24
 * @ Description：
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    public Employee getEmpByName(String lastName){
        return employeeMapper.getEmpByLastname(lastName);
    }
}
