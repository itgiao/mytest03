package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("执行啦UserServiceImpl的add方法");
    }

    @Override
    public void update() {
        System.out.println("执行啦UserServiceImpl的update方法");
    }
}

