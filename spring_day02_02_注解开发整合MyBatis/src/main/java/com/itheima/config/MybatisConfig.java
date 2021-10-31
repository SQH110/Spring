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
    @Bean
    public SqlSessionFactoryBean getsqlSessionFactoryBean(@Autowired DataSource dataSource) {//这个spring自动装配（在JDBCConfig中）
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.itheima.domain");//set代理包（包下的一切都被代理）
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    @Bean//mybatis映射配置
    public MapperScannerConfigurer getmapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }


}
