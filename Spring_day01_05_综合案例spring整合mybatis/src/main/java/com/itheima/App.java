package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 测试类(非Junit写的)
 * @author sqh
 * @create 2021-05-05 18:20
 */
public class App {
    public static void main(String[] args) throws SQLException {
        //加载配置文件
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取其中的accountService这个bean（这个是获取service对象）
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        //获取数据源对象
        DruidDataSource dataSource = (DruidDataSource) ctx.getBean("dataSource");
        //通过数据源获取其中的连接对像
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);

        //利用service查询id为1的Accout对象
        Account ac = accountService.findById(1);
        System.out.println(ac);
        connection.close();
    }
}
