package com.springboot.service.impl;

import com.springboot.entity.Department;
import com.springboot.mapper.DepartmentMapper;
import com.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author swy
 * @description:
 * @date 2020/11/30 16:09
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @Override
    public void addDept(Department department) {
        departmentMapper.addDept(department);
    }

    @Override
    public void deleteDeptById(Integer id) {
        departmentMapper.deleteDeptById(id);
    }

    @Override
    public void updateDept(Department department) {
        departmentMapper.updateDept(department);
    }
}
