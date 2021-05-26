package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("调用啦dao的add方法~~");
    }

    public UserDaoImpl() {
        System.out.println("调用啦构造方法~~");
    }
}
