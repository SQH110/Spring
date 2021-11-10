package com.itheima.service;

/**
 * service层 就一个转账操作
 *
 * @author sqh
 * @create 2021-05-23 13:21
 */
public interface AccountService {
    /**
     * 转账操作
     * 谁转给谁，转了多少钱（三个参数）
     * @param outName     出账用户名
     * @param inName      入账用户名
     * @param money       转账金额
     */
    public void transfer(String outName, String inName, Double money);
}
