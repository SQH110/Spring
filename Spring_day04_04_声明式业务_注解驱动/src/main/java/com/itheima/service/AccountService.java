package com.itheima.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

    /**
     * 转账操作
     * @param outName     出账用户名
     * @param inName      入账用户名
     * @param money       转账金额
     */
    @Transactional//里边都是默认值
    public void transfer(String outName, String inName, Double money);

}
