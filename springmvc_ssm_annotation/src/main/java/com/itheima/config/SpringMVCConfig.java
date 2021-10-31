package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author sqh
 * @create 2021-06-09
 */
@Configuration
//等同于<context:component-scan base-package="com.itheima.controller"/>
@ComponentScan("com.itheima.controller")
//等同于<mvc:annotation-driven />，还不完全相同
@EnableWebMvc
public class SpringMVCConfig {
}
