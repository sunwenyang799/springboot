package com.springboot.service.impl;

import com.springboot.entity.Employee;
import com.springboot.mapper.EmployeeMapper;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author swy
 * @description:
 * @date 2020/11/30 16:09
 */
@Service
@CacheConfig(cacheNames = "emp")//全局配置缓存属性
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法
     * CacheManager管理多个Cache组件，对缓存进行真正的CRUD操作，在Cache组件中，每一个缓存组件都有自己的唯一名字；
     * 几个属性：
     * cacheNames/values：指定缓存组件的名字
     * key：缓存数据使用的key，可以用他来指定。默认是使用方法参数的值，1-方法的返回值
     * 编写SpEl表达式；#id；参数id的值，#a0 #p0 #root.args[0]
     * keyGenerator：key的生成器，可以自己指定key的生成器的组件id
     * cacheManager/cacheResolver：指定缓存管理器，
     * condition：指定符合条件的情况下才缓存 condition = "#id > 0"
     * unless：否定缓存：当unless的条件为true时，不缓存，可以获取到结果进行判断，unless = "#result == null"
     * sync：是否使用异步模式
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "emp"/*,keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2"*/)
//    @CachePut(key = "#result.lastName")
    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "号员工");
        return employeeMapper.getEmpById(id);
    }

    @Override
    public void addEmp(Employee employee) {
        employeeMapper.addEmp(employee);
    }

    /**
     * @param id
     * @CacheEvict 清空缓存
     * key：指定要清除的key
     * allEntries = true：指定清除这个缓存中的所有数据(value="emp")
     * beforeInvocation = false 缓存的清除是否在方法运行之前执行
     * 默认是false 代表缓存清除操作在方法运行之后执行，如果出现异常就不会执行
     * true  代表缓存清除操作在方法执行之前执行，调用方法之前执行，如果出现异常还是会清除缓存
     */
    @CacheEvict(value = "emp", key = "#id"/*,allEntries = true*/, beforeInvocation = true)
    @Override
    public void deleteEmpById(Integer id) {
        System.out.println("删除了员工" + id);
        int i = 5 / 0;
//        employeeMapper.deleteEmpById(id);
    }

    /**
     * @param employee
     * @return
     * @CachePut：既调用方法，又更新缓存 运行时机：
     * 先调用目标方法
     * 将目标方法的结果缓存起来
     * <p>
     * key = "#result.id"：默认key是参数，修改之后和之前的key：id对应不上，将更新后的key也设为id
     */
    @Override
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp修改" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /***
     *  @Caching 定义复杂的缓存
     *      将key为lastName的值放入缓存中，
     *      将key为id的值放入缓存中，
     *      将key为email的值放入缓存中
     *
     *  注意！！！缓存的key不能为空,会报错
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(/*value = "emp", */key = "#result.id"),
                    @CachePut(/*value = "emp",*/ key = "#result.email")
            }
    )
//    @Cacheable(key = "#lastName")
    public Employee getEmpByLastName(String lastName) {
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }
}
