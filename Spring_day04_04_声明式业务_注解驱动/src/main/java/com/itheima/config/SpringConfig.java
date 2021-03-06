package com.itheima.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sqh
 * @create 2021-05-25 21:36
 */
@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbc.properties")
@Import({JDBCConfig.class,MybatisConfig.class})
@EnableTransactionManagement//开启事务管理（txManager放在JDBCConfig中，作为bean，会自动装配）
public class SpringConfig {
}
