package com.springboot.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author swy
 * @description:
 * @date 2020/10/12 17:17
 */
@Controller
public class UserController {

    @PostMapping("/user/login")
     public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            // 登录成功,防止表单重复提交,重定向处理
            session.setAttribute("username",username);
            return "redirect:/main";
        }else{
            map.put("msg","账号密码错误！");
            return "index";
        }
     }
}
