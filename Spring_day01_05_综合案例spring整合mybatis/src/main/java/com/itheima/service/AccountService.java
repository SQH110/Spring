package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 业务层接口
 *
 * @author sqh
 * @create 2021-05-03 21:37
 */
public interface AccountService {
    //五个操作
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);

}
