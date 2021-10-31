package com.itheima.config;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbc.properties")
@Import({JDBCConfig.class,MyBatisConfig.class})
@EnableAspectJAutoProxy//开启注解驱动
public class SpringConfig {
}
