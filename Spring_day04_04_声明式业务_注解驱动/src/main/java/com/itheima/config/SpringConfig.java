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
@EnableTransactionManagement
public class SpringConfig {
}
