package com.bean;


import lombok.Data;

import java.lang.reflect.Method;

/**
 * 用来封装controller里面调用的方法以及方法执行需要的实例对象
 */
@Data
public class MethodBean {
    private  Method method;  //具体调用的方法
    private  Object object;  //调用方法用到的对象

}
