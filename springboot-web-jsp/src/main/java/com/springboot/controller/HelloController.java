package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author swy
 * @description:
 * @date 2020/10/22 15:04
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
     public String hello(Model model){
        model.addAttribute("msg","hello");
         return "success";
     }
}
