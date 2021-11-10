package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author sqh
 * @create 2021-05-13 23:51
 */
@ContextConfiguration(classes = SpringConfig.class)//设定加载的spring上下文对应的配置
@RunWith(SpringJUnit4ClassRunner.class)//设定spring专用的类加载器
public class UserServiceTest {

    @Autowired//注入
    private AccountService accountService;

    @Test//测试FindById
    public void testFindById() {
        Account ac = accountService.findById(2);
//        System.out.println(ac);//一般使用断言测试
        Assert.assertEquals("Jack",ac.getName());//预期值与真实值
        //这种assert一般要同时写两个
    }

    @Test
    public void testFindAll() {
        List<Account> alllist = accountService.findAll();
        Assert.assertEquals(6,alllist.size());
    }
}
