package com.itheima.config;

import org.apache.ibatis.javassist.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author sqh
 * @create 2021-06-09
 */
@Configuration//变成配置类
//等同于<context:component-scan base-package="com.itheima">
@ComponentScan(value = "com.itheima",excludeFilters =
    //等同于 <context:exclude-filter type="annotation" expression="org.springframework.web.bind.annotation.RestController"/>
    @ComponentScan.Filter(type =
        FilterType.ANNOTATION,classes = {
        org.springframework.web.bind.annotation.RestController.class}))
//等同于<context:property-placeholder location="classpath*:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
//等同于<tx:annotation-driven/>；bean的名称默认为transactionManager
@EnableTransactionManagement
@Import({JDBCConfig.class,MyBatisConfig.class})
public class SpringConfig {

    //这个事务管理器是spring提供的，放这里（虽然事务属于jdbc，放那也行）
    //等同于<bean id="txManager"/>
    @Bean("transactionManager")//这个是默认值
    //等同于<class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    public DataSourceTransactionManager getDataSourceTransactionManager(@Autowired DataSource dataSource) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        //等同于<property name="dataSource" ref="dataSource"/>
        dstm.setDataSource(dataSource);
        return dstm;
    }
}