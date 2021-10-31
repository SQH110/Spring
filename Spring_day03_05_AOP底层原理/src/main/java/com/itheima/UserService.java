package com.itheima;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author sqh
 * @create 2021-05-20 17:36
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)//使用哪一种动态代理
public interface UserService {
    void save();
}
