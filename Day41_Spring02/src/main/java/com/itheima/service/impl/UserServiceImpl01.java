package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

public class UserServiceImpl01 implements UserService {
    private  String address;
    private UserDao userDao;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("调用啦UserServiceImpl01的add方法~！");
        userDao.add();
    }

}
