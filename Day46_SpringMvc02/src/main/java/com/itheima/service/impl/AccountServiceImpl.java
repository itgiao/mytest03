package com.itheima.service.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional  // 指定方法都用上事务
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Account> findAll() {
        System.out.println("执行了AccountServiceImpl的findAll方法！~");
        return dao.findAll();
    }
}
