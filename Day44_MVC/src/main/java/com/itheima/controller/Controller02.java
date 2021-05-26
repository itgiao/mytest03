package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class Controller02 {

    @RequestMapping(value="/add",method = RequestMethod.GET , params = "username")
    public String add(){
        System.out.println("执行了Controller02的add方法~！");
        return "success";
    }
}