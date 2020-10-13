package com.springboot.com.controller;

import com.springboot.com.dao.DepartmentDao;
import com.springboot.com.dao.EmployeeDao;
import com.springboot.com.entities.Department;
import com.springboot.com.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @author swy
 * @description: 员工controller
 * @date 2020/10/13 17:21
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/toAddView")
    public String toAddView(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String add(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        //redirect 重定向
        //forward 转发
        return "redirect:/emps";
    }
}
