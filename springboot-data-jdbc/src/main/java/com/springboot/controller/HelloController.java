package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 16:59 2020/10/25
 * @ Description：
 */
@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    @ResponseBody
    public List<Map<String, Object>> query(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list;
    }
}
