package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

/**
 * @author sqh
 * @create 2021-04-26 15:32
 */
public class UserDaoImpl implements UserDao {
    private String username;
    private String pwd;//密码
    private String driver;

    public UserDaoImpl(String username, String pwd,String driver) {
        this.username = username;
        this.pwd = pwd;
        this.driver = driver;
    }

    public void save() {
        System.out.println("user dao running" + username + pwd + driver);
    }
}
