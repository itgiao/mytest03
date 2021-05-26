package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {
    @RequestMapping("/show")
    public void show(int no){
        System.out.println("执行啦Controller01的show方法~");
        if (no==1){
            throw  new NullPointerException();
        }else if (no==2){
            throw  new ClassCastException();
        }else {
            throw  new RuntimeException();
        }
    }
}
