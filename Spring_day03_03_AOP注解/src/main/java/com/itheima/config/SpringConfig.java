package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author sqh
 * @create 2021-05-18 16:30
 */
@Configuration//定义Spring的配置类
@ComponentScan("com.itheima")//开启扫描资源，作为bean添加
@EnableAspectJAutoProxy//开启AOP驱动
public class SpringConfig {
}
