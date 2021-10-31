package com.itheima.service.impl;

import com.itheima.service.UserService;

/**
 * @author sqh
 * @create 2021-04-26 13:38
 */
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {//构造方法
        System.out.println("constructor is running");
    }

    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy");
    }

    public void save() {
        System.out.println("user service running...");
    }
}
