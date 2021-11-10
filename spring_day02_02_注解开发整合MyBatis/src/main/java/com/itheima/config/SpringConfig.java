package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author sqh
 * @create 2021-05-12 15:46
 */
@Configuration//注明是配置类
@ComponentScan("com.itheima")//开启扫描，路径，这样这个包下的
@PropertySource("classpath:jdbc.properties")//添加properties文件
@Import({JDBCConfig.class,MybatisConfig.class})//把这两个注入Spring的核心配置类Configuration统一管理
public class SpringConfig {

}
