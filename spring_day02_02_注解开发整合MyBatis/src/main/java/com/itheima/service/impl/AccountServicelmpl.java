package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sqh
 * @create 2021-05-03 21:39
 */
@Service("accountService")
public class AccountServicelmpl implements AccountService {

    //注入dao层接口
    @Autowired
    private AccountDao  accountDao;

    //set注入
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
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }
}
