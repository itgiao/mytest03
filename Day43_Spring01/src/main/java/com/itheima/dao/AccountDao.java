package com.itheima.dao;

public interface AccountDao {
    void kouqian(String from,int money) throws Exception;
    void jianqian(String to,int money) throws Exception;
}
