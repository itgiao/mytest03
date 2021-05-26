package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller03 {

    @ResponseBody
    @RequestMapping(value = "/returnJson01" , produces = "application/json;charset=utf-8")
    public String returnJson01() throws JsonProcessingException {
        //创建对象
        User user=new User("管理员","123456");
        //把对象转换成json字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        //直接返回json
        return json;
    }


    @ResponseBody
    @RequestMapping(value = "/returnJson02" , produces = "application/json;charset=utf-8")
    public User returnJson02() throws JsonProcessingException {
        //创建对象
        User user=new User("管理员","123456");
   //不要把对象转成json格式，springmvc会在背后帮我们转成
        return user;
    }



}
