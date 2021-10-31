package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Component;

/**
 * @author sqh
 * @create 2021-05-07 20:05
 */
@Component
public class BookDaoImpl2 implements BookDao {
    public void save() {
        System.out.println("book dao running...2");
    }
}
