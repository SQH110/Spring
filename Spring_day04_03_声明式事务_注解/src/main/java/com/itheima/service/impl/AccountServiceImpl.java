package com.itheima.service.impl;


import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void transfer(String outName, String inName, Double money) {
        accountDao.inMoney(outName,money);
//        int i = 1/0;
        accountDao.outMoney(inName,money);
    }


}
