package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author sqh
 * @create 2021-04-26 13:48
 */
public class UserApp {
    public static void main(String[] args) throws SQLException {
        //2.上一步是写配置文件，加载配置文件（这里加载类路径下的）
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取资源
//        UserService userService = (UserService) ctx.getBean("userService");
//
//        userService.save();


//        DruidDataSource ds;
//        new DruidDataSourc()//只有两种构造方式，显然是不够的
        //考虑使用set
//        ds.set();

        //用这个方法拿
        DruidDataSource dataSource = (DruidDataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);
        //获取连接对象
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection.toString());
        connection.close();
    }
}
