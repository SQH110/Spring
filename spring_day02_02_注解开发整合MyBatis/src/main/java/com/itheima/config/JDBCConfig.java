package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author sqh
 * @create 2021-05-12 15:51
 */
public class JDBCConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")//这个起名在后面整合Mybatis中使用到了
    public DataSource getDataSource () {
//        System.out.println(driver);//测试一下driver（这个进来了，说明渠道通了）
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setPassword(username);
        ds.setPassword(password);
        return ds;
    }
}
