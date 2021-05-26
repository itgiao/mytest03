package com.itheima.service.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public int add(Account account) throws Exception {
        return accountDao.add(account);
    }

    @Override
    public int delete(int id) throws Exception {
        return accountDao.delete(id);
    }

    @Override
    public int update(Account account) throws Exception {
        return accountDao.update(account);
    }

    @Override
    public List<Account> findAll() throws Exception {
        return accountDao.findAll();
    }

    @Override
    public Account findById(int id) throws Exception {
        return accountDao.findById(id);
    }
}
