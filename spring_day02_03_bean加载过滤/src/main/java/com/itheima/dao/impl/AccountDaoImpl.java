package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.stereotype.Component;

/**
 * @author sqh
 * @create 2021-05-14 18:34
 */

public class AccountDaoImpl implements AccountDao {
    public void save() {
        System.out.println("account dao running...");
    }
}
