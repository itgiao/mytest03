package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao01")
public class UserDaoImpl01 implements UserDao {
    @Override
    public void add() {
        System.out.println("调用了UserdaoImpl01的add方法~！~");
    }
}
