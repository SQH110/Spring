package com.itheima.dao.impl;

import org.springframework.beans.factory.FactoryBean;

/**
 * 主要为了一些复杂的bean做配置
 * 手动写一个FactoryBean
 * 了解即可
 *
 * @author sqh
 * @create 2021-05-16 14:18
 */
public class EqulpmentDaoImplFactoryBean implements FactoryBean {

    @Override//这个是核心方法：返回一个对象（也就是提供创造一个bean的作用）
    public Object getObject() throws Exception {
        return new EquipmentDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
