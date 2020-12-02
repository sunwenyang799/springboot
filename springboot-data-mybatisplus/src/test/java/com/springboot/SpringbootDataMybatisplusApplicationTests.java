package com.springboot;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootDataMybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","1");
        IPage<User> userList = userMapper.selectPage(new Page<>(1,4),queryWrapper);
        List<User> records = userList.getRecords();
        System.out.println(records.toString());

    }

}
