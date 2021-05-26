package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/**
 * @author admin
 */
public class UserServiceImpl implements UserService {
    public UserServiceImpl(){
        System.out.println("执行了UserServiceImpl的构造方法~！");
    }

    /*
        1. UserServiceImpl里面依赖了UserDaoImpl
        2. 它必须要给userDao的属性赋值，才能完整正常的add方法调用，否则就会出现空指针异常。
        3. 必须要让spring给这个属性userDao赋值。
        4. 想一想，给类里面的某一个属性赋值有几种方式呢？两种！
            4.1. 通过set方法来赋值
            4.2  通过构造方法赋值
        5. 让spring调用setUserDao来执行依赖的注入（属性的赋值！）
            一定要记住： 这些set方法是由spring来调用的。
     */
    private UserDao userDao ;

    public void setUserDao(UserDao userDao) {
        System.out.println("执行了setUserDao这个方法~！");
        this.userDao = userDao;
    }

    @Override
        public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！");

        //1. 自己创建对象 ，由于UserDaoImpl已经交给spring托管了，所以我们不需要自己new对象，只需要问spring的工厂要即可
        //UserDao userDao = new UserDaoImpl();
        userDao.add();
    }
}