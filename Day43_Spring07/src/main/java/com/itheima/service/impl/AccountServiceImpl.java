package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Transactional  //如果打在类上就表示类上所有方法都用事务
    @Override
    public void transfer(String from, String to, int money) {
        //扣钱
        accountDao.kouqian(from,money);
       // int i=2/0;
        //加钱
        accountDao.jiaqian(to, money);
    }
}
