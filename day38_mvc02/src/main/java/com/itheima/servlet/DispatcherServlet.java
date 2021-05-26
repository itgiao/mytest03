package com.itheima.servlet;

import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import com.itheima.bean.MethodBean;
import com.itheima.utils.ClassScannerUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    1. 这个DispatcherServlet是一个总管类，抓住所有尾巴带.do的请求
    2. 要在init方法里面扫描具体的包，解析这些包下的类已经他们的方法
    3. 这个DispatcherServlet要使用xml的方式来注册，这样才能从外面传递进来要扫描的具体包名
        通过给定初始化参数来扫描包


    init:
        1. 读取初始化参数 packageName ,知道要扫描哪个包
        2. 得到包名之后，去扫描这个包下，得到它的所有类
        3. 遍历所有的类，哪个类身上有注解 @Controller，如果有这个注解，那么就获取这个类的所有方法
        4. 遍历所有的方法，哪个方法身上有注解@RequestMapping，如果有这个注解，那么就取出来注解的value值。

    service:
        1. 获取到请求地址，截取出来字符串  /user/register
        2. 拿着这个字符串去map集合里面取出来对应methodBean对象
        3. 调用方法
 */
public class DispatcherServlet  extends HttpServlet {

    static Map<String , MethodBean> map = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            //1. 读取初始化参数 packageName ,知道要扫描哪个包
            String packageName = config.getInitParameter("packageName"); // com.itheima.controller

            //2. 得到包名之后，去扫描这个包下，得到它的所有类
            List<Class<?>> classList = ClassScannerUtils.getClasssFromPackage(packageName);

            //3. 遍历所有的类，哪个类身上有注解 @Controller，如果有这个注解，那么就获取这个类的所有方法
            for (Class<?> clazz : classList) {

                //3.1 看看谁身上有这个@Controller的注解
                if(clazz.isAnnotationPresent(Controller.class)){

                    //3.2 如果有这个controller注解，那么就获取这个字节码的所有方法
                    Method[] methods = clazz.getMethods();

                    //3.3 遍历每一个方法
                    for (Method method : methods) {

                        //3.4 判断方法是否有注解@RequestMapping, 如果有，就取出来它的value值
                        RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                        if(annotation != null){
                            //3.5 得到方法身上的注解RequestMapping的value值
                            String value = annotation.value(); //  /user/register



                            //4. 构建一个MethodBean，来封装方法和调用方法用到的实例对象
                            MethodBean mb = new MethodBean();
                            mb.setMethod(method);   //对应的register方法
                            mb.setObject(clazz.newInstance()); //对应的UserController对象

                            //5. 把映射的地址和methodBean对象，给存入到map集合中
                            map.put(value , mb) ;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1. 获取请求地址
            String uri = req.getRequestURI(); // uri = /day38_mvc01_war_exploded/user/register.do
            String path = uri.substring( req.getContextPath().length(), uri.lastIndexOf(".")); ///user/register

            //2. 去map集合里面获取methodBean对象
            MethodBean methodBean = map.get(path);

            //3. 调用方法会
            if(methodBean != null){
                Method method = methodBean.getMethod();
                Object obj = methodBean.getObject();
                method.invoke(obj ,req , resp);
            }else{
                //这样的映射地址在map集合里面找不到要调用的方法！~
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write(uri+",没有找到对应的执行方法！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
