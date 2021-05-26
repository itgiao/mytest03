package com.itheima.service.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;
    @Override
    public int add(Account account) throws Exception {
        return dao.add(account);
    }

    @Override
    public int delete(int id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public int update(Account account) throws Exception {
        return dao.update(account);
    }

    @Override
    public Account findById(int id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public List<Account> findAll() throws Exception {
        return dao.findAll();
    }
}
