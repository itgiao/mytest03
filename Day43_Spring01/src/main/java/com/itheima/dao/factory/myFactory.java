package com.itheima.dao.factory;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class myFactory {
    /**
     * 用来创建代理对象
     * 这个代理对象交给spring来管理
     */
    @Autowired
    private AccountService accountServiceImpl;
    @Autowired
    private TransactionManager tm;


    @Bean("proxyAccountService")
    public AccountService createProxy(){

        return (AccountService) Proxy.newProxyInstance(
                accountServiceImpl.getClass().getClassLoader(), //类加载器
                accountServiceImpl.getClass().getInterfaces(), //实现的接口
                new InvocationHandler() {
                    /**
                     * 外面使用代理对象做任何事情，这个invoke方法都会被执行！
                     *  现在这个invoke只关心transfer方法而已。因为我们想对transfer方法做增强。
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object result = null;

                        //先判定是不是transfer方法
                        if(method.getName().equals("transfer")){
                            try {
                                System.out.println("代理：执行转账方法：开启事务");
                                //前面先开启事务
                                tm.startTransaction();

                                //调用真实的对象方法
                                result = method.invoke(accountServiceImpl , args);

                                //提交事务
                                System.out.println("代理：执行转账方法：提交事务");
                                tm.commit();
                            } catch (Exception e) {
                                e.printStackTrace();

                                //回滚事务
                                System.out.println("代理：执行转账方法：回滚事务");
                                tm.rollBack();
                            }
                        }else{
                            //else主要是为了匹配，外面使用代理对象调用了其他的方法，那么这里就直接调用真实对象的方法即可
                            result = method.invoke(accountServiceImpl, args);
                        }
                        return result;
                    }
                }
        );
    }
}
