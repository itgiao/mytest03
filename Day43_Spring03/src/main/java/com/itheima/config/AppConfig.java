package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration   //成为核心配置类
@ComponentScan("com.itheima")   //扫描具体的包
@EnableAspectJAutoProxy     //允许aop自动代理
public class AppConfig {
}
