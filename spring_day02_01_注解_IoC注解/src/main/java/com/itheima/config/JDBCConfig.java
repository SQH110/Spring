package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 第三方资源的加载方式
 *
 * @author sqh
 * @create 2021-05-08 11:14
 */
//@Component//这个必须要加上，才能被扫描到（后面有更加标准的操作，这个就不用了，使用import）
public class JDBCConfig {

    @Bean("dataSource")//这个就是id，一定要写
    public DruidDataSource getDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.168.23.129/spring_db");
        ds.setUsername("root");
        ds.setPassword("sqh110110");
        return ds;
    }
}
