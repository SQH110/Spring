package com.itheima.service.impl;

import com.itheima.service.UserService;

/**
 * @author sqh
 * @create 2021-05-16 16:25
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        //0.将共性功能抽取出来
        //System.out.println("共性功能");//这是要被挖走的（注释掉）
        System.out.println("user service running...");
    }
}
