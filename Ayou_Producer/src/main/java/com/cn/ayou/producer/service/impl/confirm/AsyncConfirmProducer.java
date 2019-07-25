package com.cn.ayou.producer.service.impl.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @ClassName AsyncConfirmProducer
 * @Deseiption 异步确认模式
 * @Author AYOU
 * @Date 2019/7/14 15:26
 * @Version 1.0
 **/
public class AsyncConfirmProducer {
    
    private final static String QUEUE_NAME = "ASYNC_CONFIRM_QUEUE";

    public static void main(String[] args) throws Exception{
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
        String msg = "异步确认消息";
        try {
            channel.confirmSelect();
            for (int i = 0; i < 10; i++) {
                channel.basicPublish("",QUEUE_NAME,null,(msg+"-"+i).getBytes());
            }

            // 这里不会打印所有响应的ACK；ACK可能有多个，可能一个确认多条，也由可能一次确认一条
            // 异步监听确认和未确认的消息
            // 如果要重复运行，先停掉之前的生产者，清空队列
            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliyTag, boolean mutiple) {
                    //如果trye表示批量执行了deliyTag这个值之前的
                    System.out.println(String.format("Broker已确认消息，标识：%d，多个消息：%b", deliyTag,mutiple));
                }

                @Override
                public void handleNack(long deliyTag, boolean mutiple) {
                    System.out.println("Broker未确认消息，标识：" + deliyTag);
                }
            });
            System.out.println("程序执行完成");
        }finally {
            channel.close();
            connection.close();
        }
    }
}

