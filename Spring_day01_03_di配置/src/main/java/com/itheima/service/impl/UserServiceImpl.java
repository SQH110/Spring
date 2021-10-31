package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.UserService;

/**
 * @author sqh
 * @create 2021-04-26 13:38
 */
public class UserServiceImpl implements UserService {
    //在一个Service中注入多个dao是很常见的
    private BookDao bookDao;

    //构造器注入
    public UserServiceImpl(UserDao userDao) {//带参构造方法
        this.userDao = userDao;
    }

    //
    public UserServiceImpl() {//无参构造方法（反射时需要调用）

    }

    //set注入的方式
    public void setBookDao(BookDao bookDao) {//set方法
        this.bookDao = bookDao;
    }


//    public UserServiceImpl(BookDao bookDao, UserDao userDao) {
//        this.bookDao = bookDao;
//        this.userDao = userDao;
//    }

    //如何在这边注入
    //构造器注入
    //引用数据类型
    public UserServiceImpl(UserDao userDao,int num,String version) {
        this.userDao = userDao;
        this.num = num;
        this.version = version;
    }

    //********************************非引用类型set注入***********************************
    //set注入
    private int num;//非引用类型

    //非引用类型set注入
    public void setNum(int num) {
        this.num = num;
    }

    //如果是字符串，当做非引用类型即可
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    //*******************************引用类型set注入************************************
    private UserDao userDao;//引用类型变量

    //1.对需要进行诸如的变量添加set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;//把变量传递到成员变量，扩大作用域
    }

    public void save() {
        System.out.println("user service running..." + "\t" +num + "\t" +version);
        userDao.save();
        bookDao.save();
    }
}
