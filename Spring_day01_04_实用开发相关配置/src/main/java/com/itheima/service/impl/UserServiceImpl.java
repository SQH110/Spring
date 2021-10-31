package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/**
 * @author sqh
 * @create 2021-04-26 13:38
 */
public class UserServiceImpl implements UserService {
    //在一个Service中注入多个dao是很常见的
    private BookDao bookDao;
    private UserDao userDao;//引用类型

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("user service running...");
        userDao.save();
        bookDao.save();
    }
}
