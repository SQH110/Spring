package com.itheima;

import redis.clients.jedis.Jedis;

public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.23.129",6378);
        jedis.set("name","itheima");
        jedis.close();
    }
}
