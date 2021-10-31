package com.itheima.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT)//考虑到实现类的多样性，要配在接口上
public interface AccountService {

    /**
     * 转账操作
     * @param outName     出账用户名
     * @param inName      入账用户名
     * @param money       转账金额
     */
    @Transactional(
            readOnly = false,
            timeout = -1,
            isolation = Isolation.DEFAULT,
            rollbackFor = {},//java.lang.ArithmeticException.class, IOException.class
            noRollbackFor = {},
            propagation = Propagation.REQUIRED//事务传播
    )//表示开启事务
    public void transfer(String outName, String inName, Double money);

}
