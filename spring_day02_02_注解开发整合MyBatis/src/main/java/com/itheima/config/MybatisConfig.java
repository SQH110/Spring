package com.itheima.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * mybatis配置类
 *
 * @author sqh
 * @create 2021-05-13 23:00
 */
public class MybatisConfig {

    //注入第三方资源
    //设置该方法的返回值作为spring管理的bean
    @Bean
    public SqlSessionFactoryBean getsqlSessionFactoryBean(@Autowired DataSource dataSource) {//这个spring自动装配（在JDBCConfig中）
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.itheima.domain");
        //set代理包（包下的一切都被代理，这个是类型的别名设置，通过加载包的方式，代理包内的所有类的名字）
        ssfb.setDataSource(dataSource);
        //设置数据源
        return ssfb;//最终返回一个sql会话工厂Bean对象
    }

    @Bean//mybatis映射扫描配置
    public MapperScannerConfigurer getmapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");//设置基础包（映射扫描的基础包）
        return msc;
    }


}
