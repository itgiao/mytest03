package com.itheima.service.impl;

import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    //在不改动源码的前提下，给这个add方法。增强MyAdvice的功能

    @Override
    public void add() {
        System.out.println("执行啦UserServiceImpl的add方法");
    }

    @Override
    public void update() {
        System.out.println("执行啦UserServiceImpl的update方法");
    }
}
