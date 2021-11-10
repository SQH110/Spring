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

    //注入非引用类型（注入properties的资源）
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //注入第三方资源
    @Bean("dataSource")//这个要起名，因为在后面整合Mybatis中使用到了（设置该方法的返回值作为spring管理的bean）
    public DataSource getDataSource () {
//        System.out.println(driver);//测试一下driver（这个进来了，说明渠道通了）
        DruidDataSource ds = new DruidDataSource();//获取这个数据源类后给它实例化
        //配置对应参数
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setPassword(username);
        ds.setPassword(password);
        return ds;

    }
}
