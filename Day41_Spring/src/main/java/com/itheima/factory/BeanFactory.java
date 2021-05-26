package com.itheima.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 这是一个对象工厂，主要使用来负责创建对象的
 * s谁希望这个工厂帮助它创建对象，那么只要在beans.proproties里面登记别名和全路径
 * 工厂内部代码
 *     使用静态代码块来读取beans的配置文件
 *     把映射关系读取到之后，封装到一个map集合中key：别名 value：全路径名
 *     提供一个静态方法，从外面传递进来别名然后从map里面取出来对应的全路径名
 *     如果没有集合里面取出来的value 则是null，则表示对象没有beans的配置文件李里面
 */

public class BeanFactory {
    //定义一个全局变量
    static Map<String,String> map=new HashMap<>();
     //静态代码块
    static {
        //读取配置文件里面的内容
         ResourceBundle bundle = ResourceBundle.getBundle("beans");

         //得到配置文件里面的所有的key，返回一个枚举的集合，把它看成一个迭代器
         Enumeration<String> enumeration = bundle.getKeys();
         //遍历每一个key
         while (enumeration.hasMoreElements()){
             //取到啦key
             String key = enumeration.nextElement();
             //取值
             String value = bundle.getString(key);
             //把key和value都装到集合中
             map.put(key,value);
         }
     }

    /**
     * 获取对象
     */

    public static  Object getBean(String name) throws Exception {
        //从map集合中取出来别名对应的全路径
        String value = map.get(name);
        //对这个全路径进行非空判断
        if (value!=null){
            //创建返回对象
            return Class.forName(value).newInstance();
        }
        //返回null
        return null;
    }
}
