package com.controller;


import com.annotation.Controller;
import com.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @RequestMapping("/user/register")
    public void  register(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行力register方法。。。");
    }
    @RequestMapping("/user/login")
    public void  login(HttpServletRequest request ,HttpServletResponse HttpServletResponse){
        System.out.println("执行啦login方法。。。");
    }
}
