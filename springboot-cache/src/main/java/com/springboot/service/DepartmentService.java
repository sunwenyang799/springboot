package com.springboot.service;

import com.springboot.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author swy
 * @description:
 * @date 2020/11/30 16:07
 */
public interface DepartmentService {

    Department getDeptById(Integer id);

    void addDept(Department department);

    void deleteDeptById(Integer id);

    void updateDept(Department department);
}
