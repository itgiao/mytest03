package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Controller02 {

    @RequestMapping("/returnStr01")
    public void returnStr01(HttpServletResponse response) throws IOException {
        response.getWriter().write("success~!~");
    }

    @ResponseBody
    @RequestMapping(value = "/returnStr02",produces = "text/html;charset=utf-8")
    public String returnStr02()  {
        return "这是返回的数据2";
    }
}
