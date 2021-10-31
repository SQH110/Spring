package com.itheima.service.impl;


import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private RedisTemplate redisTemplate;//redis本身就是提供数据的，所以在业务层注入模板类

    public void save(Account account) {
    }

    public void changeMoney(Integer id, Double money) {//改变值
        //等同于redis中set account:id:1 100
        redisTemplate.opsForValue().set("account:id:"+id,money);//表名+字段名
    }

    public Double findMondyById(Integer id) {//获取值
        //等同于redis中get account:id:1
        Object money = redisTemplate.opsForValue().get("account:id:" + id);
        return new Double(money.toString());
    }
}
//        redisTemplate.type()//获得类型
//        redisTemplate.persist()
//        redisTemplate.move()//移动
//        redisTemplate.hasKey()
//        redisTemplate.getExpire()
//        redisTemplate.expire()
//        redisTemplate.delete()
//        redisTemplate.rename();
//以上无法归属某个数据类型

//        redisTemplate.opsForValue().;//对应具体数据类型的操作
//        redisTemplate.opsForHash().;
//        redisTemplate.opsForList().;
//        redisTemplate.opsForSet().;
//        redisTemplate.opsForZSet();
//
//
//        redisTemplate.boundValueOps().;//阻塞式操作
//
//        redisTemplate.slaveOf();//操作主从的
//        redisTemplate.slaveOfNoOne();
//
//        redisTemplate.opsForCluster()//操作集群的