package com.itheima.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author sqh
 * @create 2021-05-18 16:17
 */
public class AOPPointcut {

    @Pointcut("execution(* *..*(..))")
    public void pt1(){ }
}
