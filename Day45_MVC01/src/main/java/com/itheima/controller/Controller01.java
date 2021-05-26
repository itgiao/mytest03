package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Controller01 {

    @RequestMapping("/page01")
    public ModelAndView page01(){
        //构建对象
        ModelAndView mv = new ModelAndView();
        //封装数据
        mv.addObject("username","张飞");
        //封装视图
        mv.setViewName("success");
        return mv;
    }
    /**
     * 让spring从方法中的参数中传进去
     */
    @RequestMapping("/page02")
    public ModelAndView page02(ModelAndView mv){
        //封装数据
        mv.addObject("username","李白");
        //封装视图
        mv.setViewName("success");
        return mv;
    }

    /**
     * 通过model对象，方法的返回值，返回页面的名字
     */

    @RequestMapping("/page03")
    public  String page03(Model m){
        //封装数据
        m.addAttribute("username","鲁班");
        return "success";
    }

    /**
     * 要求springmvc传递进来model对象，方法的返回值，返回页面的名字
     */
    @RequestMapping("/page04")
    public String page04(HttpServletRequest request){
        request.setAttribute("username","德玛西亚");
        return "success";
    }

    /**
     * 通过session传递
     */
    @RequestMapping("/page05")
    public String page05(HttpSession session){
        //封装数据
        session.setAttribute("username","虞姬");
        return "redirect:/success.jsp";

    }
}
