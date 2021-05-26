package com.itheima.controller;

import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Retention;

@Controller
public class UserController {

    @RequestMapping("/user/register")
    public void register(HttpServletRequest req , HttpServletResponse resp){
        System.out.println("执行了UserController的register方法~！");
    }


    public void login(HttpServletRequest req , HttpServletResponse resp){
        System.out.println("执行了UserController的login方法~！");
    }
}
