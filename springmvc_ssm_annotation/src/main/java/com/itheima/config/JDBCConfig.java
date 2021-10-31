package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author sqh
 * @create 2021-06-09
 */
public class JDBCConfig {
    //使用注入，读取propperties文件中的属性值，等同于<property name="*** value="${jdbc.***}"/>
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    //定义dataSource的bean，等同于<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    @Bean("datasource")
    public DataSource getDataSource() {
        //创建对象
        DruidDataSource ds = new DruidDataSource();
        //手动调用set方法，等同于set属性注入<property name="****" value="${jdbc.***}"/>
        ds.setUsername(userName);
        ds.setPassword(password);
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        return ds;
    }

}