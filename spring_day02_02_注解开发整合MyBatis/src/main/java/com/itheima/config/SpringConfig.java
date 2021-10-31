package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author sqh
 * @create 2021-05-12 15:46
 */
@Configuration
@ComponentScan("com.itheima")//开启扫描，路径
@PropertySource("classpath:jdbc.properties")//添加properties文件
@Import({JDBCConfig.class,MybatisConfig.class})//把这两个注入Configuration统一管理
public class SpringConfig {

}
