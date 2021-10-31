package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

/**
 * 这个类是spring核心配置类，把xml核心配置文件干掉
 *
 * @author sqh
 * @create 2021-05-08 14:59
 */
@Configuration//这行代表整个application.xml文件
@ComponentScan("com.itheima")//这行表示扫描范围
@Import(JDBCConfig.class)
@Order(1)
public class SpringConfig2 {
    @Bean("b2")
    public String getB2() {
        System.out.println("b2");
        return "";
    }
}
