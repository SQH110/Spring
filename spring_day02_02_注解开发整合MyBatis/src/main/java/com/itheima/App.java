package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类(非Junit写的)
 * @author sqh
 * @create 2021-05-05 18:20
 */
public class App {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountService = (AccountService) ctx.getBean("accountService");
//        Account ac = accountService.findById(1);
//        System.out.println(ac);

        // 使用注解配置上下文导入对应的配置类
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ctx.getBean("dataSource");
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        Account ac = accountService.findById(3);
        System.out.println(ac);

    }
}
