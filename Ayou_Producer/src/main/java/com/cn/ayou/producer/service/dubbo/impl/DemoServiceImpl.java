package com.cn.ayou.producer.service.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cn.ayou.producer.service.dubbo.DemoService;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName DemoServiceImpl
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/21 16:44
 * @Version 1.0
 **/
@Service(interfaceClass = DemoService.class)
public class DemoServiceImpl  implements DemoService {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws  InterruptedException{


        Condition condition = lock.newCondition();
        condition.await();
        condition.signalAll();
    }
}
