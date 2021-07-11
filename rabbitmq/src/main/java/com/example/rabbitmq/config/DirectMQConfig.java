package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分发队列模型配置
 * @Author wzq
 * @Date 2021/7/6
 **/
@Configuration
public class DirectMQConfig {

    /**
     * direct queue name
     */
    public static final String DIRECT_QUEUE_NAME = "direct.queue";
    /**
     * direct exchange
     */
    public static final String DIRECT_EXCHANGE_NAME = "direct.exchange";
    /**
     * routing key
     */
    public static final String DIRECT_ROUTING_KEY_NAME = "direct.routing.key";

    /**
     * 交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    /**
     * 创建一条持久化的、非排他的、非自动删除的队列
     * @return
     */
    @Bean
    public Queue directQueue(){
        return new Queue(DIRECT_QUEUE_NAME);
    }

    /**
     * Binding,将该routing key的消息通过交换机转发到该队列
     * @return
     */
    @Bean
    public Binding directBinding(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(DIRECT_ROUTING_KEY_NAME);
    }

}
