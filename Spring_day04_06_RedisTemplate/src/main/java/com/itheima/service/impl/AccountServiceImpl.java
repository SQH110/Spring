package com.itheima.service.impl;


import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    //再业务层注入redis
    @Autowired
    private RedisTemplate redisTemplate;//redis本身就是提供数据的，所以在业务层注入模板类

    public void save(Account account) {
    }

    //改变值
    public void changeMoney(Integer id, Double money) {
        //等同于redis中set account:id:1 100
        redisTemplate.opsForValue().set("account:id:" + id, money);//表名+字段名
    }

    //获取值
    public Double findMondyById(Integer id) {
        //等同于redis中get account:id:1
        Object money = redisTemplate.opsForValue().get("account:id:" + id);
        return new Double(money.toString());
    }

    //判断是否有对应的key
    public Boolean getKeys(Integer id) {
        Boolean result = redisTemplate.hasKey(id);
        return result;
    }

}
//        redisTemplate.type()//获得数据类型
//        redisTemplate.persist()//持久化一个key
//        redisTemplate.move()//移动一个key
//        redisTemplate.hasKey()//是否有这个key
//        redisTemplate.getExpire()//获取有效时长
//        redisTemplate.expire()//设置有效期
//        redisTemplate.delete()
//        redisTemplate.rename();
//以上无法归属某个数据类型

//        redisTemplate.opsForValue().;//对应具体数据类型的操作这里是String
//        redisTemplate.opsForHash().;//hash
//        redisTemplate.opsForList().;//list
//        redisTemplate.opsForSet().;//set
//        redisTemplate.opsForZSet();//有序集合
//
//
//        redisTemplate.boundValueOps().;//阻塞式操作
//
//        redisTemplate.slaveOf();//操作主从的
//        redisTemplate.slaveOfNoOne();
//
//        redisTemplate.opsForCluster()//操作集群的