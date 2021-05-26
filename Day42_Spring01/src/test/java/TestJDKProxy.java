import com.itheima.proxy.Start;
import com.itheima.proxy.StartAdvice;
import com.itheima.proxy.SuperStart;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {

    @Test
    public  void testDemo(){
        //创建真实对象，目标对象，被代理的对象
        SuperStart superStart = new SuperStart();
        //创建代理对象
        Start proxyInstance = (Start) Proxy.newProxyInstance(superStart.getClass().getClassLoader(),      //目标对象使用什么类加载器，代理对象就使用什么类加载器
                superStart.getClass().getInterfaces(),   //目标实现什么接口，代理对象就实现什么接口
                new InvocationHandler() {       //调用处理器，协调目标对象和代理对象之间的关系
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /**
                         * 外面的代理对象，执行什么方法，那么这个invoke方法都会被执行
                         * proxy  代理对象
                         * method  外面用代理对象调用的方法对象
                         * args   调用方法用到的参数
                         * return  真实对象的方法执行返回的结果
                         */
                        StartAdvice advice = new StartAdvice();
                        advice.before();    //增强功能
                        //使用反射的手段方法执行
                        Object obj = method.invoke(superStart, args);
                        advice.after();


                        return obj;
                    }
                });
        //操作代理对象
        proxyInstance.sing("冰雨");
        System.out.println("=============================");
        proxyInstance.dance("DJ");

    }

    @Test
    public void TestDemo02(){
        //创建真实对象
        SuperStart start=new SuperStart();
        //创建代理对象
       SuperStart proxyStart = (SuperStart) Enhancer.create(SuperStart.class,   //父类是谁
                new MethodInterceptor() {       //方法拦截器，外面使用代理执行什么，拦截器就会执行什么
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        /**
                         * 0 代理对象
                         * method 方法对象
                         * objects  参数
                         * methodProxy  方法代理
                         * return 把真实对象的执行结果返回出去
                         *
                         */


                        if (method.getName().equals("sing")) {
                            StartAdvice startAdvice = new StartAdvice();
                            startAdvice.before();
                            //使用反射的手法来对调用方法
                            Object obj = method.invoke(start, objects);
                            startAdvice.after();
                            return obj;
                        }
                        return method.invoke(start, objects);


                    }





                });
        //使用代理对象调用方法
        proxyStart.sing("下雨天");
        System.out.println("=================");
        proxyStart.dance("如果我是DJ你会爱我吗！！！");
    }
}
