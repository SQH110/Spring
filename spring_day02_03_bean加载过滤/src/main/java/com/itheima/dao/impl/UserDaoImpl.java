package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @author sqh
 * @create 2021-05-14 15:28
 */

public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("user dao running...");
    }
}
