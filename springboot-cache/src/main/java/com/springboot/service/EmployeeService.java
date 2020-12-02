package com.springboot.service;

import com.springboot.entity.Employee;

/**
 * @author swy
 * @description:
 * @date 2020/11/30 15:07
 */
public interface EmployeeService {

    Employee getEmpById(Integer id);

    void addEmp(Employee employee);

    void deleteEmpById(Integer id);

    Employee updateEmp(Employee employee);

    Employee getEmpByLastName(String lastName);
}
