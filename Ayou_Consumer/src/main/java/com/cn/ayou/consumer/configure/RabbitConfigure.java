package com.cn.ayou.consumer.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName RabbitConfigure
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/12 11:15
 * @Version 1.0
 **/
@Configuration
@PropertySource("classpath:ayoumq.properties")
public class RabbitConfigure {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


   /* @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;*/




    @Value("AYOU_FIRST_QUEUE")
    private String firstQueue;

    @Value("AYOU_SECOND_QUEUE")
    private String secondQueue;

    @Value("AYOU_THIRD_QUEUE")
    private String thirdQueue;

    @Value("AYOU_FOURTH_QUEUE")
    private String fourthQueue;

    @Value("AYOU_FIVETH_QUEUE")
    private String fivethQueue;

    @Value("AYOU_DIRECT_EXCHANGE")
    private String directExchange;

    @Value("AYOU_TOPIC_EXCHANGE")
    private String topicExchange;

    @Value("AYOU_FANOUT_EXCHANGE")
    private String fanoutExchange;

    /**
     * 连接
     * @return
     */
    /*@Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }*/

    /*@Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }*/



    //队列
    @Bean("ayouFirstQueue")
    public Queue getFirstQueue(){
        return new Queue(firstQueue);
    }

    @Bean("ayouSecondQueue")
    public Queue getSecondQueue(){
        return new Queue(secondQueue);
    }

    @Bean("ayouThirdQueue")
    public Queue getThirdQueue(){
        return new Queue(thirdQueue);
    }

    @Bean("ayouFourthQueue")
    public Queue getFourthQueue(){
        return new Queue(fourthQueue);
    }

    @Bean("ayouFivethQueue")
    public Queue getFivethQueue(){
        return new Queue(fivethQueue);
    }

    //交换机

    //直连
    @Bean("ayouDirectExchange")
    public DirectExchange getDirectExchange(){
        return new DirectExchange(directExchange);
    }

    //主题
    @Bean("ayouTopicExchange")
    public TopicExchange getTopicExchange(){
        return new TopicExchange(topicExchange);
    }

    //广播
    @Bean("ayouFanoutExchange")
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    public Binding bindFirst(@Qualifier("ayouFirstQueue")Queue queue, @Qualifier("ayouDirectExchange")DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("ayou.best");
    }

    @Bean
    public Binding bindSecond(@Qualifier("ayouSecondQueue")Queue queue, @Qualifier("ayouTopicExchange")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.ayou.*");
    }

    @Bean
    public Binding bindThird(@Qualifier("ayouThirdQueue")Queue queue, @Qualifier("ayouTopicExchange")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("Love.#");
    }

    @Bean
    public Binding bindFourth(@Qualifier("ayouFourthQueue")Queue queue, @Qualifier("ayouFanoutExchange")FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }
    @Bean
    public Binding bindFiveth(@Qualifier("ayouFivethQueue")Queue queue, @Qualifier("ayouFanoutExchange")FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }
}
