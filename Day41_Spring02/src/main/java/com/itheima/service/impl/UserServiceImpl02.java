package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;


public class UserServiceImpl02 implements UserService {

    private  String adress;
    private UserDao userDao;

    //定义构造方法
    public UserServiceImpl02(String adress, UserDao userDao) {
        this.adress = adress;
        this.userDao = userDao;
    }

    @Override
    public void add() {
    System.out.println("调用啦UserServiceImpl02的add方法~~~~~");
    userDao.add();

    }
}
