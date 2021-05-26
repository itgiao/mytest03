package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Scope
public class UserServiceImpl implements UserService {
    //告诉spring,要把userdaoimpl的对象注入进来
    @Autowired
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("userServiceImpl..add...");
        userDao.add();

    }
}
