package com.itheima.dao.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public int add(Account account) throws SQLException {
        String sql="insert into t_account values(null,?,?)";
        return queryRunner.update(sql,account.getName(),account.getMoney());
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql="delete from t_account where id=?";
        return queryRunner.update(sql,id);
    }

    @Override
    public int update(Account account) throws SQLException {

        String sql="update t_account set name=?,money=? where id=?";
        return queryRunner.update(sql,account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public Account findById(int id) throws SQLException {
        String sql="select * from t_account where id=?";
        return queryRunner.query(sql , new BeanHandler<Account>( Account.class), id);
    }

    @Override
    public List<Account> findAll() throws SQLException {
        String sql="select * from t_account";
        return queryRunner.query(sql,new BeanListHandler<Account>(Account.class));
    }
}
