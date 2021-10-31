package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @author sqh
 * @create 2021-05-07 20:05
 */
@Component("userDao2")//id不同
public class UserDaoImpl2 implements UserDao {

    public void save() {
        System.out.println("user dao running...2");
    }
}
