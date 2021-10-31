package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.config.SpringConfig2;
import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author sqh
 * @create 2021-05-07 20:06
 */
public class App {
    public static void main(String[] args) {

        //不使用xml配置
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class, SpringConfig2.class);//通过字节码
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);//通过字节码
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");//使用当前类路径来加载配置文件
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();
//****************************测试dao的bean定义****************************
//        UserDao userdao = (UserDao) ctx.getBean("userDao");
//        userdao.save();

//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();
//****************************测试dao的bean定义****************************
//        ctx.close();//手动关闭，且单例的时候，可以看到destory方法

//****************************测试第三方资源定义****************************
//        DataSource datasource = (DataSource) ctx.getBean("dataSource");
//        System.out.println(datasource);
//****************************测试第三方资源定义****************************


    }
}
