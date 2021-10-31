package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @author sqh
 * @create 2021-05-18 13:54
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    public int save(int i, int m) {
        System.out.println("user service running..." + i + "," + m);
        return 100;
    }
}
