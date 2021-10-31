package com.itheima.config;

import com.itheima.dao.impl.BookDaoImpl2;
import org.springframework.beans.factory.annotation.Configurable;
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
@Import(JDBCConfig.class)//JDBCConfig中的@Component不需要了
@Order(2)
public class SpringConfig {
    @Bean("b1")
    public String getB1() {
        System.out.println("b1");
        return "";
    }
}
