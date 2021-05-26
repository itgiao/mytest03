package com.itheima.service.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    /**
     * 由于现在已经交给spring来管理对象啦，所以当我们需要其他类对象，
     * 那么只要让spring注入即可
     * @param account
     * @return
     */

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public int add(Account account) throws SQLException {
        return accountDao.add(account);
    }

    @Override
    public int delete(int id) throws SQLException {
        return accountDao.delete(id);
    }

    @Override
    public int update(Account account) throws SQLException {

        return accountDao.update(account);
    }

    @Override
    public Account findById(int id) throws SQLException {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() throws SQLException {
        return accountDao.findAll();
    }


}
