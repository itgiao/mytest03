package com.itheima.AppConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.itheima")
@EnableTransactionManagement  //允许事务管理员工作
public class AppConfig {
    //创建dataSource，让spring管理起来
    @Bean("ds")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql:///spring01");
        ds.setUser("root");
        ds.setPassword("root");
        return ds;
    }
    //创建jdbcTemplate，让spring管理起来
    @Bean
    public JdbcTemplate getTemplate(DataSource ds){
        return new JdbcTemplate(ds);
    }
    //创建事务管理员，让spring管理起来
    @Bean
    public PlatformTransactionManager getManager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
