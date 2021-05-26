package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager tm;

    @Override
    public void transfer(String from, String to, int money) {
        /**
         * 需要注入dao和TransactionManager
         * 转账
         */

        //开启事务
        try {
            tm.startTransaction();
            //扣钱
            accountDao.kouqian(from, money);
            //模拟转账中途出现问题
          //  int a = 1 / 0;

            //加钱
            accountDao.jianqian(to, money);
            //提交事务
            tm.commit();

        } catch (Exception throwables) {
            throwables.printStackTrace();
            //出现异常就回滚事务
            try {
                tm.rollBack();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
