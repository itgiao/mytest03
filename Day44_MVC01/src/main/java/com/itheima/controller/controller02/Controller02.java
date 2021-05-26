package com.itheima.controller.controller02;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class Controller02 {
/**
 * 使用原始的ServletApi来获取数据
 */
@RequestMapping("/register02")
public  String register02(HttpServletRequest request, HttpServletResponse response, HttpSession session){
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println(username+"="+password);
    //cookie
    Cookie cookie=new Cookie("name","admin" );
    response.addCookie(cookie);
    //session
    session.setAttribute("age",19);
    System.out.println("session="+session.getAttribute("age"));
    return  "success";
}
}
