package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author sqh
 * @create 2021-05-07 20:05
 */
@Component("userDao")
@DependsOn("userService")//依赖这个id代表的bean，那么先加载别人
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("dao running...");
    }

    public void save() {
        System.out.println("user dao running...1");
    }
}
