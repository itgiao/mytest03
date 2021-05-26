package com.itheima.dao.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public int add(Account account) throws Exception {
        String sql = "insert into t_account values(null , ? ,  ?)";
        return runner.update(sql , account.getName(), account.getMoney());
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from t_account where id = ?";
        return runner.update(sql ,id);
    }

    @Override
    public int update(Account account) throws Exception {
        String sql = "update t_account set name = ?, money = ?  where id = ?";
        return runner.update(sql , account.getName(), account.getMoney() , account.getId());
    }

    @Override
    public Account findById(int id) throws Exception {
        String sql = "select * from t_account where id = ?";
        return runner.query(sql , new BeanHandler<Account>( Account.class) , id);
    }

    @Override
    public List<Account> findAll() throws Exception {
        String sql = "select * from t_account";
        return runner.query(sql , new BeanListHandler<Account>( Account.class));
    }

}
