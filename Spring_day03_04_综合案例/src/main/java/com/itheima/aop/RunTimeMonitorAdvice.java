package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 运行时间监控
 *
 * @author sqh
 * @create 2021-05-18 17:40
 */
@Component//加入sping
@Aspect//是切面类
public class RunTimeMonitorAdvice {
    //切入点，监控业务层接口（查询）
    @Pointcut("execution(* com.itheima.service.*Service.find*(..))")
    public void pt() { }

    @Around("pt()")
    public Object runtimeAround(ProceedingJoinPoint pjp) throws Throwable {
        /*
        环绕通知是在原始方法的前后添加功能
        ProceedingJoinPoint对象可以调用proceed()，实现对原始方法的调用
         */

        /*
        进一步，我们要知道哪个接口方法及其对应时间
        通过ProceedingJoinPoint得出执行方法的name
         */
        Signature signature = pjp.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println(declaringTypeName);//com.itheima.service.AccountService
        String name = signature.getName();
        System.out.println(name);//findAll、findById

        long sum = 0l;
        Object ret = null;
        //一般测试万次运行时长
        for (int i = 0; i < 10000; i++) {
            long startTime = System.currentTimeMillis();
            ret = pjp.proceed(pjp.getArgs());//proceed()添加参数可要可不要
            long endTime = System.currentTimeMillis();
            sum += endTime - startTime;
        }

        System.out.println(declaringTypeName+ ":" + name + "（万次运行时长）运行了" + sum + "ms");
        return ret;
    }

}
