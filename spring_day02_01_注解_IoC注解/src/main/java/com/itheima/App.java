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

        //不使用xml配置，需要用这个注解配置应用上下文对象，可以读取多个配置类
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class, SpringConfig2.class);//通过字节码
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);//通过字节码
        /*
            这里可以发现一个问题
            当我们只写一个配置类的时候，其实两个配置类都能找到
            只有在我们把配置类的对应注解注释掉的时候才会真的不再加载这个配置类
            我们在写的时候，依然还是通过class类，因为当我们全部删除class类时，
            运行时会报错，告知我们bean找不到
         */

        //类路径下的读取配制文件，应用于xml配置时
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
