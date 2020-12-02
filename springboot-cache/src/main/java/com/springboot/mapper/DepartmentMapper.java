package com.springboot.mapper;

import com.springboot.entity.Department;
import com.springboot.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author swy
 * @description:
 * @date 2020/11/30 15:12
 */
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

    @Insert("insert into department(departmentName) values(#{departmentName})")
    void addDept(Department department);

    @Delete("delete from department where id  = #{id}")
    void deleteDeptById(Integer id);

    @Update("update department set departmentName = #{departmentName}, where id = #{id}  ")
    void updateDept(Department department);
}
