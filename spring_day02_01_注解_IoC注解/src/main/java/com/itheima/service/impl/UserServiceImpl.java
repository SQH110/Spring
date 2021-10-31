package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author sqh
 * @create 2021-05-07 20:06
 */
//定义bean，后面添加bean的id
@Component(value = "userService")//添加组件需要定义名称，但是value = "userService"这个是可以省略为"userService"
//设定bean的作用域
@Scope("singleton")
public class UserServiceImpl implements UserService {

    //非引用类型注入
    @Value("3")//里边是具体的值（这里可以用引用代替，更低的耦合性）
    private int num;
    @Value("itheima")
    private String version;

    //引用类型注入
    @Autowired//默认按类型匹配
//    @Qualifier("userDao")//指定名称后就可以避免开发两个相同名字（主要是类相同，类的实例化对象可以不同）的id的情况，用的不多
    private UserDao userDao;
    @Autowired//自动装配
    private BookDao bookDao;

    //注解开发，可以省略了下面的set()方法来使用，更加简便
    /*public void setNum(int num) {
        this.num = num;
    }

    public void setVersion(String version) {
        this.version = version;
    }*/

    public UserServiceImpl() {
        System.out.println("service running...");
    }

    public void save() {
        System.out.println("user service running..." + num + version);
        userDao.save();
        bookDao.save();

    }

    //设定bean的生命周期
    @PostConstruct//构造后处理
    public void init() {
        System.out.println("user service init..");
    }

    @PreDestroy//销毁前处理
    public void destory() {
        System.out.println("user servide destory");
    }
}
