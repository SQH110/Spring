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

    //前置通知
    public void before(JoinPoint jp) {
        //通知获取参数数据的第一种方式
        Object[] args = jp.getArgs();
        //拿到对象数组
        System.out.println("before..." + args[0]);
    }


    //通知获取参数数据的第二种方式
    public void before1(int x) {
        System.out.println("第二种方式获取参数数据 before1(int)..." + x);
    }


    //后置通知
    public void after(JoinPoint jp) {
        //通知获取参数数据的第一种方式
        Object[] args = jp.getArgs();
        System.out.println("after..." + args[0]);
    }


    //返回后通知
    public Object afterReturning(Object ret) {
        System.out.println("afterReturing..." + ret);
        return ret;
    }

//    public void afterReturning() {
//        System.out.println("afterReturing...");
//    }

    //抛出异常后通知
    public void afterThrowing(Throwable t) {
        System.out.println("afterThrowing..." + t.getMessage());//获取抛出异常的信息
    }


    //环绕通知
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("around before...");

        //对原始方法调用，这样就分先后了
        Object ret = null;
        try {
            ret = pjp.proceed();//对原始方法的调用取得那个返回值，给它提升权限
        } catch (Throwable throwable) {

            System.out.println("around...exception..." + throwable.getMessage());
            /*
            这里和上面的afterThrowing不同，上面这个是没有处理异常
            而下面这个，捕捉到了异常后，处理的方式是打印异常的信息
            而且因为程序没有执行完，它的返回值永远都是null
             */
        }
        System.out.println("around after..." + ret);//通知获取返回值数据(方式不同的)
//        System.out.println("around after...");
        return ret;
    }




}
