package com.itheima.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component      //让spring来管理这个类
@Aspect     //让spring认识这个类，它的方法主要是增强别人
public class MyAdvice {

    //抽取切入点表达式
    @Pointcut("execution(* com.itheima..*.*(..))")
    public void a(){
        System.out.println("aaaaaaaaaaaaaa");
    }
    @After("a()")
    public void print1(){
        System.out.println("执行啦myadvice的print方法~~");
    }


    @Before("execution(* com.itheima..*.*(..))")
    public void print(){
        System.out.println("执行啦myadvice的print方法~~");
    }
}


