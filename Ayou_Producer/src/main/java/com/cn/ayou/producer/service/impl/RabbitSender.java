package com.cn.ayou.producer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.ayou.producer.util.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName RabbitSender
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/12 22:45
 * @Version 1.0
 **/
@Component
public class RabbitSender  implements RabbitTemplate.ConfirmCallback {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Value("AYOU_DIRECT_EXCHANGE")
    private String directExchange;

    @Value("AYOU_TOPIC_EXCHANGE")
    private String topicExchange;

    @Value("AYOU_FANOUT_EXCHANGE")
    private String fanoutExchange;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Transactional(rollbackFor = Exception.class,timeout = 5000)
    public void send() {
        Merchant merchant = new Merchant("1001", "a direct msg : 学习", "天通苑北二区");
        amqpTemplate.convertAndSend(directExchange, "ayou.best", JSON.toJSONString(merchant));
        amqpTemplate.convertAndSend(topicExchange, "b.ayou.a", "主题 前后各一个");
        amqpTemplate.convertAndSend(topicExchange, "Love.best", "主题 我爱你");
        amqpTemplate.convertAndSend(fanoutExchange,"", JSON.toJSONString(merchant));

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info(" 回调id:" + correlationData);
        if (b) {
            logger.info("消息成功消费");
        } else {
            logger.info("消息消费失败:" + s);
        }
    }
}
