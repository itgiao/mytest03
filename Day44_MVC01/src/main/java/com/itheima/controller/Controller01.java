package com.itheima.controller;

import com.itheima.bean.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Controller
public class Controller01 {
    /**
     * 获取简单的参数
     * 要求：方法的形参名必须和页面的表单项的name的属性值一样
     */
    @RequestMapping("/simple")
    public String getSimpleParms(String username,String password){
        System.out.println("执行啦getSimpleParms的方法");
        System.out.println(username+"="+password);
        return "success";
    }

   @RequestMapping("/obj")
    public String getObjectParams(Account a){
        System.out.println("执行啦getObjectParams的方法");
        System.out.println("a = " + a);
        return "success";
    }
    /**
     * 获取数组的参数
     * 要求：方法参数的名字必须和页面提交的name属性值一样
     */

    @RequestMapping("/array")
    public String getArrayParams(String[] hobby){
        System.out.println("hobby="+ Arrays.toString(hobby));
        return "success";
    }

    /**
     * 获取的参数中包含对象属性
     */
    @RequestMapping("/obj01")
    public  String getObjIncludeObj(Account01 account01){
        System.out.println("执行啦account01方法");
        System.out.println("account01 = " + account01);

        return "success";
    }
    /**
     * 页面传递包含集合
     */

    @RequestMapping("/obj02")
    public String getObjList(User user){
        System.out.println("执行啦getObjList。。。");
        System.out.println("user = " + user);
        return "success";
    }

    @RequestMapping("/object03")
    public String getObjectIncludeMap(User01 user01){
        System.out.println("执行了Controller01 的getObjectIncludeMap方法~！");
        System.out.println("user02=" + user01);
        return "success";
    }

    /**
     * 提交数据包含日期
     */
    @RequestMapping("/register")
    public  String register(User02 user02){
        System.out.println("user02 = " + user02);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(user02.getBirthday());
        System.out.println("s = " + s);
        return "success";
    }
}
