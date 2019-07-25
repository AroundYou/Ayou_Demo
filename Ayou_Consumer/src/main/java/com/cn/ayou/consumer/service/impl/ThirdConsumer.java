package com.cn.ayou.consumer.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @ClassName ThirdConsumer
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/12 19:09
 * @Version 1.0
 **/
@Component
@PropertySource("classpath:ayoumq.properties")
@RabbitListener(queues = "${com.ayou.thirdQueue}", containerFactory = "rabbitListenerContainerFactory")
public class ThirdConsumer {

    @RabbitHandler
    public void process(@Payload String msg){
        System.out.println("Third Queue msg: "+msg);
    }
}
