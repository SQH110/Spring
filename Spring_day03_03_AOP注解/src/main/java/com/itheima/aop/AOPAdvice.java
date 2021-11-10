package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 通知类
 * @author sqh
 * @create 2021-05-18 13:53
 */

@Component//配置为一个bean
@Aspect//配置为一个切面
public class AOPAdvice {

    //配置切入点（后期单独放到一个类中，提高重用性，规范管理）
//    @Pointcut("execution(* *..*(..))")
//    public void pt() {
//
//    }

    @Before("AOPPointcut.pt1()")//配置前置通知
    public void before() {
        System.out.println("前置before...");
    }

    @After("AOPPointcut.pt1()")
    public void after() {
        System.out.println("后置after...");
    }

    @AfterReturning("AOPPointcut.pt1()")
    public void afterReturing() {
        System.out.println("返回后afterReturning...");
    }

    @AfterThrowing("AOPPointcut.pt1()")
    public void afterThrowing() {
        System.out.println("抛出异常后afterThrowing...");
    }

    @Around("AOPPointcut.pt1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前around before...");
        Object ret = pjp.proceed();
        System.out.println("环绕后around after...");
        return ret;
    }
}
