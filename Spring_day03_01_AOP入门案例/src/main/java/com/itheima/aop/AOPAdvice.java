package com.itheima.aop;

/**
 * 把共性的功能，制作成方法，保存到专用的类中，删除原始业务中对应的功能
 * 使用配置链接关系
 *
 * @author sqh
 * @create 2021-05-16 19:41
 */
//1.制作通知类，在类中完成一个方法用于完成共性功能
public class AOPAdvice {
    public void function() {
        System.out.println("共性功能");
    }
}
