package com.itheima.pojo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Min(value = 18,message = "18岁以下才能注册")
    private int age;
}
