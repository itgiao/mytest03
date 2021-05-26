package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller02 {

    @ResponseBody
    @RequestMapping("/show01")
    public void show(){
        System.out.println("执行啦Controller02的show方法~~");
    }
}
