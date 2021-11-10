package com.itheima.dao.impl;

import com.itheima.dao.EquipmentDao;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author sqh
 * @create 2021-05-15 21:15
 */
public class EquipmentDaoImpl implements EquipmentDao, InitializingBean {//多实现了一个bean初始化前执行方法的规范

    @Override
    public void save() {
        System.out.println("equipment dao running...");
    }

    /*
    InitializingBean：这个要写到bean上，初始化bean时运行
    早期使用这种实现这个接口，后面使用配置
    这个不同于BeanfactoryPostProcessor，BeanPostProcessor的通用化处理
    这个是个性化处理
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EquipmentDaoImpl ....bean.... init...");
    }
}
