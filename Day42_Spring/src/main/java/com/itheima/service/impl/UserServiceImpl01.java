package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class UserServiceImpl01 implements UserDao {

    @Resource(name = "userDaoImpl01")
    private UserDao ud;



    @Value("北京")
    private String address;

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~" +  address);
        ud.add();
    }


    @PostConstruct
    public void init(){
        System.out.println("调用了init方法~！");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("调用了destroy方法~！");
    }
}
