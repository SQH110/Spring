package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author sqh
 * @create 2021-05-07 20:05
 */
//作为bean交给spring管理
@Component
@Primary//加一个优先级（适合两个同样的bean，当你的@Component不注明id的时候，如果到三个相同时，按名称确认即使用@qualifier）
//@PropertySource(value = {"classpath:JDBC.properties","classpath:abc.properties"},ignoreResourceNotFound = false)//加载属性源(注意这个格式)
@PropertySource("classpath:JDBC.properties")
public class BookDaoImpl implements BookDao {

    //非引用类型的注入
    @Value("${jdbc.userName}")
    private String username;
    @Value("${jdbc.passWord}")
    private String passWord;

    public void save() {
        System.out.println("book dao running...1" + username + passWord);
    }
}
