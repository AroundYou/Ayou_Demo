package com.cn.ayou.producer;

import com.cn.ayou.producer.service.impl.RabbitSender;
import com.cn.ayou.producer.service.impl.RedisProducerDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerApplicationTests {

    @Autowired
    RabbitSender rabbitSender;

    @Autowired
    RedisProducerDemo redisProducerDemo;


    @Test
    public void contextLoads() {
    //    redisProducerDemo.lockImplRedis("lgzz");
      //  rabbitSender.send();
    }

}
