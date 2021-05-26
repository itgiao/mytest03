package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*@Component*/
public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
     //创建modelandview对象
        ModelAndView mv=new ModelAndView();
        //跳转到的页面
        mv.setViewName("/error.jsp");
        //也可以对异常进行详细的判别
        if (e instanceof NullPointerException){
            mv.addObject("msg","出现空指针异常啦~");
        }else if (e instanceof ClassCastException){
            mv.addObject("msg","出现类型转换异常啦~");
        }else {
            mv.addObject("msg","出现运行异常啦~");
        }
        return mv;
    }

}
