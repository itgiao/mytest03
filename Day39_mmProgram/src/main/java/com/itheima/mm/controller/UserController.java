package com.itheima.mm.controller;

import com.alibaba.fastjson.JSON;
import com.annotation.Controller;
import com.annotation.RequestMapping;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class UserController {

    @RequestMapping("/user/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp){
        try {
            //1. 清空session
            req.getSession().invalidate();

            //2. 响应
            Result result = new Result(true , "退出成功");
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();

            try {
                Result result = new Result(false , "退出失败");
                resp.getWriter().write(JSON.toJSONString(result));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @RequestMapping("/user/login")
    public void login(HttpServletRequest req, HttpServletResponse resp){

        try {
            //1. 获取请求参数
            User user = JSON.parseObject(req.getInputStream() , User.class);
            //序列化、反序列化 ==》 序列化
            //2. 交代service干活
             UserService userService = new UserService();
            User loginUser = userService.login(user);

            //3. 对请求做出响应
            Result result = null;
            if(loginUser != null){

                //登录成功
                //1. 存user到session
                req.getSession().setAttribute("user", loginUser);

                //2. 告诉页面成功了
                result = new Result(true , "登录成功");
            }else{
                //登录失败 ，告诉页面失败了！
                result = new Result(false , "登录失败");
            }
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
