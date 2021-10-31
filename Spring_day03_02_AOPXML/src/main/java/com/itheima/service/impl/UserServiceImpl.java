package com.itheima.service.impl;

import com.itheima.service.UserService;

/**
 * @author sqh
 * @create 2021-05-16 16:25
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save(int i) {
        System.out.println("user service running..." + i);
//        int i = 1/0;//设置一个异常(对比，after和afterreturing)
    }

    @Override
    public int update() {
        System.out.println("user service update running...");
        return 100;
    }

    @Override
    public void delete() {
        System.out.println("user service delete runing...");
        int i = 1/0;
    }
}
