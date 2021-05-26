package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.utils.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    /**
     * 需要注入两个对象，queryRunner,TransactionManager
     * @param from
     * @param money
     * @throws Exception
     */
    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private TransactionManager tm;

    /**
     * 扣钱的方法
     * @param from
     * @param money
     * @throws Exception
     */
    @Override
    public void kouqian(String from, int money) throws Exception {
            String sql="update t_account set money=money-? where name =?";
             queryRunner.update(tm.getConnect(),sql,money,from);
    }


    /**
     * 加钱的方法
     * @param to
     * @param money
     * @throws Exception
     */
    @Override
    public void jianqian(String to, int money) throws Exception {
        String sql="update t_account set money=money+? where name =?";
        queryRunner.update(tm.getConnect(),sql,money,to);


    }
}
