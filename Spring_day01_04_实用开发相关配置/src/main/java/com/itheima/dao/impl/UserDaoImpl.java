package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

/**
 * @author sqh
 * @create 2021-04-26 15:32
 */
public class UserDaoImpl implements UserDao {

    private String userName;
    private String password;

    //提供set方法用于set注入
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save() {
        System.out.println("user dao running" + "\t" + userName + "\t" + password);
    }
}
