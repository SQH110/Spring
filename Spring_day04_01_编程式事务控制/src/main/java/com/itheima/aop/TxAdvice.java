package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * 把业务层的事务处理功能抽取出来做成AOP通知，利用环绕通知运行期动态织入
 *
 * @author sqh
 * @create 2021-05-23 15:47
 */
public class TxAdvice {
    private DataSource dataSource;//设置数据源

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //使用环绕型通知round
    public Object transactionManager(ProceedingJoinPoint pjp) throws Throwable {
        //开启事务（需要注入数据源，且和applicationContext中一致）
        PlatformTransactionManager ptm = new DataSourceTransactionManager(dataSource);
        //事务定义对象（可以选则用默认定义对象或者自定义）
        TransactionDefinition td = new DefaultTransactionDefinition();
        //事务状态对象（从事务对象中获取）
        TransactionStatus ts = ptm.getTransaction(td) ;//需要一个事务定义对象

        //调用原始方法（这里原始方法有参数，可以手动添加）
        Object ret = pjp.proceed(pjp.getArgs());//这个pjp.getArgs()写不写都可以，写了更加标准

        //提交事务
        ptm.commit(ts);//需要一个事务状态对象

         return ret;
    }
}
