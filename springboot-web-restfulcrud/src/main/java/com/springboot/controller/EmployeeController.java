package com.springboot.controller;

import com.springboot.dao.DepartmentDao;
import com.springboot.dao.EmployeeDao;
import com.springboot.entities.Department;
import com.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/emp")
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

    @GetMapping("/emp/{id}")
    public String toEditView(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        model.addAttribute("emps",employee);
        return "emp/add";
    }

    @PutMapping("/emp")
   public String update(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
   }

   @DeleteMapping("/emp/{id}")
   public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
   }
}
