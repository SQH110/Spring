package com.itheima;

import com.itheima.service.UserService;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sqh
 * @create 2021-05-18 13:47
 */
public class APP {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userservice = (UserService) ctx.getBean("userService");
        int ret = userservice.save(666, 888);
        System.out.println("应用程序调用执行结果..." + ret);

    }
}
