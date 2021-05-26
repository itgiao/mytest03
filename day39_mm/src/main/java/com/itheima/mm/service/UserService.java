package com.itheima.mm.service;

import com.itheima.mm.dao.UserDao;
import com.itheima.mm.pojo.User;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserService {

    public User login(User user) throws IOException {

        //1. 使用工具类获取SqlSession
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 通过session获取代理对象
        UserDao userDao = session.getMapper(UserDao.class);

        //3. 使用代理对象调用方法
        user = userDao.findUser(user);

        //4. 关闭session
        session.close();

        //5. 返回查询的user对象。
        return user;
    }
}
