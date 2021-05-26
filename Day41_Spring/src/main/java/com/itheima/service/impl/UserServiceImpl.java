package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() throws Exception {
        //有工厂就问工厂要
        System.out.println("ufskjfsjf");
        UserDao userDao=(UserDao) BeanFactory.getBean("ud");
        userDao.add();
    }

}
