package com.itheima.proxy;

public class SuperStart implements Start{
    @Override
    public void sing(String name) {
        System.out.println("明星在唱歌："+name);
    }

    @Override
    public void dance(String name) {
        System.out.println("明星在跳舞："+name);
    }
}
