package com.springboot.controller;

import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swy
 * @description:
 * @date 2020/11/30 16:29
 */
@RestController()
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
     public Employee getEmpById(@PathVariable("id") Integer id){
         return employeeService.getEmpById(id);
     }

     @GetMapping("/emp")
     public Employee updateEmp(Employee employee){
         Employee emp = employeeService.updateEmp(employee);
         return emp;
     }

     @GetMapping("/deleteEmp")
     public String deleteEmp(Integer id){
        employeeService.deleteEmpById(id);
        return "success";
     }

     @GetMapping("/lastName/{lastName}")
     public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
     }
}
