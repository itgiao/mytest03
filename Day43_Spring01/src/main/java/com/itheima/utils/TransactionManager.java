package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class TransactionManager {

    private ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    /**
     * 把threadLocal看成一个map即可，它的key：当前线程
     * value：就是存进去的值
     * 它的作用就是保证在同一线程内得到同一个连接value
     */
    @Autowired
    private DataSource dataSource;
    /**
     * 获取连接
     */

    public Connection getConnect() throws SQLException {
        //从threadLocal中里面拿到连接
        Connection connection = threadLocal.get();
        //判断从里面拿到的是否不为空
        if (connection==null){
            //如果没有就从连接池里面获取
             connection = dataSource.getConnection();
             //需要把这个连接存到threadLocal里面去
            threadLocal.set(connection);
        }
        return connection;
    }

    //关闭连接
    public void close(Connection connection) throws SQLException {
        if (connection!=null){
            connection.close();
        }
    }

    /**
     * 开启事务
     */
    public  void startTransaction() throws SQLException {
        //获取连接
        Connection connection = getConnect();
        //开启事务
        connection.setAutoCommit(false);
    }

    /**
     * 提交事务
     */

    public void commit() throws SQLException {
        Connection connection=getConnect();
        connection.commit();
        //关闭连接
        close(connection);
    }

    /**
     * 回滚事务
     */

    public  void rollBack() throws SQLException {
        //获取连接
        Connection connection = getConnect();
        //回滚事务
        connection.rollback();
        //关闭连接
        close(connection);
    }

}
