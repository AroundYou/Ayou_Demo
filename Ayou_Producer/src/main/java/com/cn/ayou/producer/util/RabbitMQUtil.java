package com.cn.ayou.producer.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName RabbitMQUtil
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/13 17:56
 * @Version 1.0
 **/
public class RabbitMQUtil {

    public RabbitMQUtil(){}

    public Channel RabbitMQChannel(String QUEUE_NAME) throws Exception{
        Channel channel = null;
        Connection connection = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            return channel;
        } finally {
                connection.close();
        }
    }
}
