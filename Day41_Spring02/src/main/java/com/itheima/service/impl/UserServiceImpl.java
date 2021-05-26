package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    public UserDao userDao;
    @Override
    public void add() {
        System.out.println("执行啦service层的add方法！！！");
        userDao.add();
    }

    public UserServiceImpl() {
        System.out.println("执行啦service层的构造方法~~~~");
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("执行啦setUserDao这个方法·····");
        this.userDao=userDao;
    }
}
