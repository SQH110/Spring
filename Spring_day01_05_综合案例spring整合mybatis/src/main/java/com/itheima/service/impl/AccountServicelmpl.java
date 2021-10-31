package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;

import java.util.List;

/**
 * @author sqh
 * @create 2021-05-03 21:39
 */
public class AccountServicelmpl implements AccountService {

    //注入dao层接口
    private AccountDao  accountDao;

    //set方法用于set注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public List<Account> findAll() {
        return accountDao.findAll(); //有返回值
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }
}
