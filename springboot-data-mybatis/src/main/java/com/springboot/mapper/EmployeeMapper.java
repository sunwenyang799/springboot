package com.springboot.mapper;

import com.springboot.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 19:49 2020/11/24
 * @ Description：
 */
//@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByLastname(String lastName);
}
