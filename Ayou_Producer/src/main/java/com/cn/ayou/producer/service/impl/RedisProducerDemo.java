package com.cn.ayou.producer.service.impl;

import com.cn.ayou.producer.util.RedisUtil;
import com.cn.ayou.producer.util.SnowFlakeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @ClassName RedisProducerDemo
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/16 16:50
 * @Version 1.0
 **/
@Component
@Slf4j
public class RedisProducerDemo {

    /*@Autowired
    RedisUtil redisUtil;*/


    public static void main(String[] args) {

        /*RedisProducerDemo redisProducerDemo = new RedisProducerDemo();
        redisProducerDemo.lockImplRedis("lgzz");*/

        Set<String> set = new HashSet<>();
        String str1 = "123";
        String str = new String("123");
        System.out.println(str == str1);
        System.out.println(str.equals(str1));
        set.add(str);
        set.add(str1);
        //UUID.randomUUID().toString();
        /*SnowFlakeGenerator.Factory factory = new SnowFlakeGenerator.Factory();
        factory.create()*/
        List<String> list = new ArrayList<>();
        list.retainAll(set);
        set.forEach((a)->{
            System.out.println(a);
        });
    }

    public void lockImplRedis(String lockStr){

        final int db3 = 0;

     /*   redisUtil.set(lockStr,"111",db3);
        long resExpire = redisUtil.expire(lockStr,60,db3);
        log.info("resExpire: "+resExpire);
        String result = redisUtil.get(lockStr,db3);
        log.info("result: "+result);*/

        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        Transaction t =  jedis.multi();
        //t.set()
        //t.sadd();
        boolean getLockFlag =  "OK".equals(jedis.set(lockStr,"2","NX","EX",10));
        log.info(getLockFlag?"1获得锁成功!":"1获得锁失败!");

        boolean getLockFlags1 =  "OK".equals(jedis.set(lockStr,"2","NX","EX",10));
        log.info(getLockFlags1?"2获得锁成功!":"2获得锁失败!");



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean getLockFlags =  "OK".equals(jedis.set(lockStr,"2","NX","EX",10));
        log.info(getLockFlags?"3获得锁成功!":"3获得锁失败!");

        t.exec();
        // t.discard();
        jedis.close();
    }

}
