package com.springboot.mapper;

import com.springboot.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author swy
 * @description:
 * @date 2020/11/30 15:07
 */
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    void addEmp(Employee employee);

    @Delete("delete from employee where id  = #{id}")
    void deleteEmpById(Integer id);

    @Update("update employee set lastName = #{lastName},email = #{email},gender = #{gender} , d_id = #{dId} where id = #{id}  ")
    void updateEmp(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
