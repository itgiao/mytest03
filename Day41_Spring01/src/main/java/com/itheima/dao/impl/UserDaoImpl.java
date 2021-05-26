package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){
        System.out.println("执行了UserDaoImpl的构造方法~！");
    }
    @Override
    public void add() {
        System.out.println("调用了UserDaoImpl的add方法~！~");
    }
}
