package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.security.PrivateKey;

/**
 * @author sqh
 * @create 2021-05-23 13:24
 */
public class AccountServiceImpl implements AccountService {

    //导入dao对象
    private AccountDao accountDao;

    //set注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


//****************************AOP前备份*************************************
//    private DataSource dataSource;//设置数据源与Mybatis一致
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public void transfer(String outName, String inName, Double money) {
        //通过dao操作，存钱和取钱
        accountDao.inMoney(outName,money);
        int i = 10/0;//异常后下面就不运行了
        accountDao.outMoney(inName,money);

    }


//**********************************AOP之前的备份**********************************************
//    public void transfer(String outName, String inName, Double money) {
//
//        /*
//        下面两个是独立的操作，中间加一个异常看看
//        可以发现在数据库中，两个账户的数据总和发生了异常
//        按理来说，要求完成一致性，但是由于两个操作是独立的，就无可避免的受到影响
//         */
//        /*
//        解决方案：
//        在业务层中，把这两个放到一个事务中管理
//         */
//
//        //开启事务(使用平台事务管理接口的实现类)（需要注入数据源，且和applicationContext中一致）
          //用mybatis实现了数据层，我们就用对应的平台事务管理器
//        PlatformTransactionManager ptm = new DataSourceTransactionManager(dataSource);
//        //事务定义对象（可以选则用默认定义对象或者自定义）
        /*
            事务定义中有很多属性值
            要么一个个写
            要么就使用默认值
        */
//        TransactionDefinition td = new DefaultTransactionDefinition();
//        //事务状态对象（从平台事务管理器对象中获取，注入事务定义参数）
//        TransactionStatus ts = ptm.getTransaction(td) ;//需要一个事务定义对象
//
//        accountDao.inMoney(outName,money);
//        int i = 10/0;//异常后下面就不运行了
//        accountDao.outMoney(inName,money);
//
//        //提交事务
//        ptm.commit(ts);//需要一个事务状态对象
//
//    }
}
