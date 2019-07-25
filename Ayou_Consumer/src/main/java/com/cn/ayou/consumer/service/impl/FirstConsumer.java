package com.cn.ayou.consumer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.ayou.consumer.util.Merchant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName FirstConsumer
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/12 17:32
 * @Version 1.0
 **/
@Component
@PropertySource("classpath:ayoumq.properties")
@RabbitListener(queues = "${com.ayou.firstQueue}", containerFactory = "rabbitListenerContainerFactory")
public class FirstConsumer {

    @RabbitHandler
    public void process(@Payload String msg, Channel channel) throws IOException {
        Merchant merchant = JSONObject.parseObject(msg, Merchant.class);
        System.out.println("First Queue msg: "+merchant.getName()+" "+merchant.getAddress());
        channel.basicAck(1,true);
        //System.out.println("First Queue msg: "+msg);
    }
}
