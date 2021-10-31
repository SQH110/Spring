package com.itheima.service;

import com.itheima.config.SpringConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

/**
 * @author sqh
 * @create 2021-05-18 16:33
 */
@RunWith(SpringJUnit4ClassRunner.class)//使用spring类加载器
@ContextConfiguration(classes = SpringConfig.class)//上下文
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        int ret = userService.save(888,666);
        Assert.assertEquals(100,ret);//断言
    }
}
