package com.itheima.service;

import com.itheima.bean.Account;

import java.util.List;

public interface AccountService {
    int add(Account account) throws Exception;
    int delete(int id) throws  Exception;
    int update(Account account) throws Exception;
    List<Account> findAll() throws Exception;
    Account findById(int id)throws Exception;
}
