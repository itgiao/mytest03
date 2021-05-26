package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor02 implements HandlerInterceptor {
    //在controller的方法被调用之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle02");
        return false;
    }
    /*
    处理之后
    当controller方法已经执行完毕，得到方法的返回值之后执行
     */

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行啦HandlerInterceptor02的postHandle的方法~~");
    }
    /*
    准备完成之后
    当视图渲染完毕之后执行
     */

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行了HandlerInterceptor02的afterCompletion方法~~");
    }
}
