package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author sqh
 * @create 2021-05-03 21:22
 */
public interface AccountDao {

    //五个操作
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);
}
