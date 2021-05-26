package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account01 {
    private int id;
    private String name;
    private int money;

    //注入城市信息对象
    private Address address;
}
