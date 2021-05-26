package com.itheima.mm.dao;

import com.itheima.mm.pojo.User;

public interface UserDao {

    /**
     * 登录方法，根据用户名和密码来查询用户
     * @param user
     * @return
     */
    User findUser (User  user);
}
