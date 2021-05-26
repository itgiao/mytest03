package com.Servlet;

import com.annotation.Controller;
import com.annotation.RequestMapping;
import com.bean.MethodBean;
import com.utils.ClassScannerUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DispatcherServlet extends HttpServlet {
    static Map<String, MethodBean> map= new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            //读取初始化参数 packageName ,知道扫描哪个包
            String packageName = config.getInitParameter("packageName");
            //得到包名之后 ，去扫描这个包下得所有类
            List<Class<?>> classList = ClassScannerUtils.getClasssFromPackage(packageName);
            //遍历所有的类，哪个类身上有注解@Controller,如果有这个注解，那么就获取这个类的方法
            for (Class<?> aClass : classList) {
                if (aClass.isAnnotationPresent(Controller.class)){
                    //如果有这个注解，那么就获取这个字节码文件的方法
                    Method[] methods = aClass.getMethods();
                    //遍历每一个方法
                    for (Method method : methods) {
                        //判断方法是否有@requestMapping注解
                        RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                        if (annotation!=null){
                            //如果不等于null就获取value
                            String value = annotation.value();

                            //构建一个methodBean，来封装方法和调用方法用到的实例对象
                            MethodBean mb = new MethodBean();
                            mb.setMethod(method);
                            mb.setObject(aClass.newInstance());
                            map.put(value,mb);
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
            //获取请求地址
            String uri = req.getRequestURI();
            String path = uri.substring(req.getContextPath().length(), uri.lastIndexOf("."));
            //去map集合里面获取methodBean对象
            MethodBean methodBean = map.get(path);
            //调用方法
            if (methodBean!=null){
                Method method = methodBean.getMethod();
                Object obj = methodBean.getObject();
                System.out.println("method = " + method);
                method.invoke(obj,req,resp);
            }
            else {
                //z这样的映射在map集合下找不到要调用的方法
                resp.setContentType("text/html; charset=UTF-8");
                resp.getWriter().write(uri+",没有找到对应的执行方法！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        }


}
