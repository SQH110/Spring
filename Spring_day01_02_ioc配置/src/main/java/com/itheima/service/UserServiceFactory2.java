package com.itheima.service;

import com.itheima.service.impl.UserServiceImpl;

/**
 * 创造一个遗留工厂类（实例工厂的方式）
 *
 * 实例工厂
 * @author sqh
 * @create 2021-04-26 14:55
 */
public class UserServiceFactory2 {
    public UserService getService() {//非静态方法
        System.out.println("对象使用实例工厂创建的");
        return new UserServiceImpl();
    }
}
