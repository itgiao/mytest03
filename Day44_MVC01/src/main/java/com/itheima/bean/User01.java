package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User01 {
    private int id;
    private  String username;
    private String password;
    private int age;

    //写上账户
    private Map<String,Account> accountMap;
}
