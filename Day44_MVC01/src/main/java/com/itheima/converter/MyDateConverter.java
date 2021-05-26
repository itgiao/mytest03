package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        try {
            System.out.println("进入converter");
            //定义日期类型格式对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //把字符串转换为日期对象
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
