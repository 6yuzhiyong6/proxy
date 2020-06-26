package com.aaa.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Mr.Yu
 * @Date: 2020/6/24 12:23
 * @description
 * @Version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String turnLoginPage(){
        return "login";
    }

    @RequestMapping("/")
    public String turnIndexPage(){
        return "index";
    }
}

