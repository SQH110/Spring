package com.itheima.service;

import com.itheima.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sqh
 * @create 2021-05-25 21:37
 */
@RunWith(SpringJUnit4ClassRunner.class)//设定Spring专用的类加载器
@ContextConfiguration(classes = SpringConfig.class)//设定加载的spring上下文对应的配置
public class UserServiceTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void testTransfer() {
        accountService.transfer("Jock1","Jock2",100D);
    }
}
