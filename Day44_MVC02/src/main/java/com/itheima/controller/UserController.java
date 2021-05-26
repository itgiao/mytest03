package com.itheima.controller;

import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
     @RequestMapping("/requestBody")
    public String requestBody(@RequestBody String body){
        System.out.println("body = " + body);
        return "success";
    }

    /**
     * @requestBody作用
     * 把页面提交过来的数据封装到一个对象身上
     */

    @RequestMapping("/getJsonData")
    public String getJsonData(@RequestBody User user){
        System.out.println("user = " + user);
        return "success";
    }
    /**
     * 截取地址里面的{id}这个位置的数据，然后把它赋值给aaa
     */
    @RequestMapping("/user/delete/{idd}")
    public String pathVariable(@PathVariable("idd") int a){
        System.out.println("a=" + a);
        return "success";
    }
/**
 * 获取某一个请求头，把它的值赋值给value
 * 请求头的名字必须是这次请求里面携带的
 */
@RequestMapping("/requestHeader")
public String requestHeader(@RequestHeader(value="User-Agent") String value){
    System.out.println("value=" + value);
    return "success";
}

    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue(value="JSESSIONID") String value){
        System.out.println("value=" + value);
        return "success";
    }
}
