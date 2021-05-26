package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {
    //使用物理视图：完整路径

    @RequestMapping("sayHi")
    public String sayHi(){
        System.out.println("周大帅。。。");
        return "/success.jsp";
    }

    @RequestMapping("sayHi01")
    public String sayHi01(){
        System.out.println("周大帅。。。01");
        return "success";
    }
}
