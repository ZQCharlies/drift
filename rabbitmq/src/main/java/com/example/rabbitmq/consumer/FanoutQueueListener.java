package com.example.rabbitmq.consumer;

import com.example.rabbitmq.config.FanoutMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author wzq
 * @Date 2021/7/11
 * 订阅模型 fanout  交换机把消息发送给绑定过的所有队列
 **/
@Slf4j
@Component
public class FanoutQueueListener {

    //注解版
//    @RabbitListener(bindings = {@QueueBinding(
//            value = @Queue(name = "topic.fanout1",durable = "true",autoDelete = "true"),
//            exchange = @Exchange(value = "topic.fanout.exchange",type = "fanout"))},
//            concurrency = "1-10")
//    public void subProcessOne(Message message){
//        String content = new String(message.getBody());
//        System.out.println("one"+content);
//
//    }
//
//    @RabbitListener(bindings = {@QueueBinding(
//            value = @Queue(name = "topic.fanout2",durable = "true",autoDelete = "true"),
//            exchange = @Exchange(value = "topic.fanout.exchange",type = "fanout"))},
//            concurrency = "1-10")
//    public void subProcessTwo(Message message){
//        String content = new String(message.getBody());
//        System.out.println("two"+content);
//
//    }


    //配置版
    @RabbitListener(queues = FanoutMQConfig.FANOUT_QUEUE_ONE,concurrency = "1-10")
    public void subProcessOne(Message message){
        String content = new String(message.getBody());
        log.info("fanout one,message:{}",content);

    }

    @RabbitListener(queues = FanoutMQConfig.FANOUT_QUEUE_TWO,concurrency = "1-10")
    public void subProcessTwo(Message message){
        String content = new String(message.getBody());
        log.info("fanout two,message:{}",content);
    }

}
