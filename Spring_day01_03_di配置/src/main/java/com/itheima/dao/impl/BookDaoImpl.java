package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;

/**
 * @author sqh
 * @create 2021-04-26 16:35
 */
public class BookDaoImpl implements BookDao {

    private List<String> al;
    private Properties properties;
    private int[] arr;
    private Set hs;
    private HashMap hm;

    public void setAl(List al) {
        this.al = al;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void setHs(Set hs) {
        this.hs = hs;
    }

    public void setHm(HashMap hm) {
        this.hm = hm;
    }

    public void save() {
        System.out.println("book dao running...");
        System.out.println("Arraylist:" + al);
        System.out.println("Properties" + properties);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("HashSet:" + hs);
        System.out.println("HashMap" + hm);
    }
}
