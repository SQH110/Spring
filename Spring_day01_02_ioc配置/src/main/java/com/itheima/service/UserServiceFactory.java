package com.itheima.service;

import com.itheima.service.impl.UserServiceImpl;

/**
 * 创造一个遗留工厂类（静态工厂的模式）
 *
 * 静态工厂
 * @author sqh
 * @create 2021-04-26 14:55
 */
public class UserServiceFactory {
    public static UserService getService() {//静态方法
        System.out.println("对象使用静态工厂创建的");
        return new UserServiceImpl();
    }
}
