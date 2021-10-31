package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author sqh
 * @create 2021-05-18 16:47
 */
public interface AccountService {
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);
}
