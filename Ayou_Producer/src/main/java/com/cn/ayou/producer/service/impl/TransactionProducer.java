package com.cn.ayou.producer.service.impl;


import com.cn.ayou.producer.util.Merchant;
import com.cn.ayou.producer.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @ClassName TransactionProducer
 * @Deseiption 事务模式
 * @Author AYOU
 * @Date 2019/7/13 14:30
 * @Version 1.0
 **/
public class TransactionProducer {

    private final static String QUEUE_NAME = "ORIGIN_QUEUE";

    public static void main(String[] args) throws  Exception{

        String message = "Come Ayou Happy Together!";

        /*RabbitMQUtil rabbitMQUtil = new RabbitMQUtil();
        Channel channel = rabbitMQUtil.RabbitMQChannel(QUEUE_NAME);*/
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /**
         * 声明队列
         * 参数1：队列名
         * 参数2：是否持久化，如果设置为true，服务器重启了队列仍然存在
         * 参数3：是否为独享队列（排他性队列），只有自己可见的队列，即不允许其它用户访问
         * 如果为true 该队列的特点是  1、只对首次声明它的连接（Connection）可见
         *                           2、会在其连接断开的时候自动删除。
         * 参数4：当没有任何消费者使用时，自动删除该队列
         * 参数5：其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        try{
            //开启事务模式
            channel.txSelect();
            //发送消息
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

            channel.txCommit();
            System.out.println(" [x] Sent '" + message + "'");

        }catch (Exception e){
            channel.txRollback();
            System.out.println("消息回滚!");
        }finally {
            channel.close();
            connection.close();
        }
    }
}
