package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
//该文件已经可以删除了（使用tx命名空间配置后）
public class TxAdvice {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Object tx(ProceedingJoinPoint pjp) throws Throwable {

        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(dataSource);//使用set的方法
        TransactionDefinition td = new DefaultTransactionDefinition();
        TransactionStatus ts = dstm.getTransaction(td);

        Object ret = pjp.proceed(pjp.getArgs());//原始方法调用

        dstm.commit(ts);
        return ret;
    }
}
