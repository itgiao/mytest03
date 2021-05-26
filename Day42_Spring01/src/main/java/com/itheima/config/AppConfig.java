package com.itheima.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:db.properties")
public class AppConfig {
    //需要把properties里面的内容给注入到4个属性身上

    @Value("${driverClass}")
    private String driverClass;

    @org.springframework.beans.factory.annotation.Value("${jdbcUrl}")
    private String jdbcUrl;

    @org.springframework.beans.factory.annotation.Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Bean
    public QueryRunner runner(javax.sql.DataSource ds) {
        return new QueryRunner(ds);
    }

    @Bean
    public DataSource ds() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driverClass);
        ds.setJdbcUrl(jdbcUrl);
        ds.setUser(user);
        ds.setPassword(password);
        return ds;
    }
}