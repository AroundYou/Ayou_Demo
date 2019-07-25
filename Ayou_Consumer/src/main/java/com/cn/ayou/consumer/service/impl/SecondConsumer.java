package com.cn.ayou.consumer.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecondConsumer
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/12 19:06
 * @Version 1.0
 **/
@Component
@PropertySource("classpath:ayoumq.properties")
@RabbitListener(queues = "${com.ayou.secondQueue}", containerFactory = "rabbitListenerContainerFactory")
public class SecondConsumer {

    @RabbitHandler
    public void process(@Payload String msg){
        System.out.println("Second Queue msg: "+msg);
    }
}
