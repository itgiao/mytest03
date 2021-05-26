package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

public class UserServiceImpl03 implements UserService {

    private String address;
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void add() {
        System.out.println("执行啦03服务层~~~~~~");
        System.out.println("address = " + address);
        userDao.add();
    }
}
