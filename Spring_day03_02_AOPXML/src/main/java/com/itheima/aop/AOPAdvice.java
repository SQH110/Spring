package com.itheima.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 把共性的功能，制作成方法，保存到专用的类中，删除原始业务中对应的功能
 * 使用配置链接关系
 *
 * @author sqh
 * @create 2021-05-16 19:41
 */
//1.制作通知类，在类中完成一个方法用于完成共性功能
public class AOPAdvice {
    public void before(JoinPoint jp) {//前置
        Object[] args = jp.getArgs();//通知获取参数数据的第一种方式
        System.out.println("before..." + args[0]);
    }


    //通知获取参数数据的第二种方式
    public void before1(int x) {
        System.out.println("before(int)..." + x);
    }


    public void after(JoinPoint jp) {//后置
        Object[] args = jp.getArgs();
        System.out.println("after..." + args[0]);
    }


    //通知获取返回值数据
    public void afterReturing(Object ret) {//返回后通知
        System.out.println("afterReturing..." + ret);
    }


    public void afterThrowing(Throwable t) {//抛出异常后通知
        System.out.println("afterThrowing..." + t.getMessage());
    }


    public Object around(ProceedingJoinPoint pjp) {//环绕通知
        System.out.println("around before...");
        //对原始方法调用
        Object ret = null;
        try {
            ret = pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("around...exception..." + throwable.getMessage());
            /*
            这里和上面的afterThrowing不同，上面这个是没有处理异常
            而下面这个，捕捉到了异常后，处理的方式是打印这句话
            而且因为程序没有执行完，它的返回值永远都是null
             */
        }
        System.out.println("around after..." + ret);//通知获取返回值数据(方式不同的)
//        System.out.println("around after...");
        return null;
    }




}
