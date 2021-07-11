package com.example.rabbitmq.producer;

import com.example.rabbitmq.config.DirectMQConfig;
import com.example.rabbitmq.config.FanoutMQConfig;
import com.example.rabbitmq.config.TopicMQConfig;
import com.example.rabbitmq.config.WorkMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wzq
 * @Date 2021/7/6
 * workQueue队列模型，消息分发;角色1、生产者 2、队列 3、消费者
 **/
@Slf4j
@RestController
@RequestMapping("/producer")
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @description: 简单队列模型
     * @Param:
     * @author: wzq
     * @date: 2021/7/6 4:00 下午
     */
    @GetMapping(value = "/simple/sendMessage")
    public void  sendMessageToSimple(String message){
        log.info("message:{}",message);
        rabbitTemplate.convertAndSend("simple",message);
    }

    /**
     * work queue
     * @param message
     */
    @GetMapping(value = "/work/sendMessage")
    public void  sendMessageToWork(String message){
        for (int i = 0; i < 8; i++) {
            String concatMessage = message.concat(String.valueOf(i));
            log.info("message:{}",concatMessage);
            rabbitTemplate.convertAndSend(WorkMQConfig.WORK_QUEUE_NAME, concatMessage);
        }
    }

    /**
     * 订阅模型 direct模型 根据路由键转发到指定队列
     * @param message
     */
    @GetMapping("/subscribe/direct/sendMessage")
    public void sendMessageToDirect(String message){
        for (int i = 0; i < 8; i++) {
            String concatMessage = message.concat(String.valueOf(Math.random()));
            log.info("message:{}",concatMessage);
            rabbitTemplate.convertAndSend(DirectMQConfig.DIRECT_EXCHANGE_NAME,DirectMQConfig.DIRECT_ROUTING_KEY_NAME,concatMessage);
        }
    }

    /**
     * 订阅模型 fanout模型 由交换机转发到多个队列
     * @param message
     */
    @GetMapping("/subscribe/fanout/sendMessage")
    public void sendMessageByFanout(String message){
        for (int i = 0; i < 8; i++) {
            String concatMessage = message.concat(String.valueOf(Math.random()));
            rabbitTemplate.convertAndSend(FanoutMQConfig.FANOUT_EXCHANGE,null,concatMessage);
        }
    }


    /**
     * 订阅模型 topic模型 根据路由键转发消息到队列，其中一个队列可以绑定多个"通配符"的路由键
     * @param message
     */
    @GetMapping("/subscribe/topic/sendMessage")
    public void sendMessageByTopic(String message){
        for (int i = 0; i < 8; i++) {
            String concatMessage = message.concat(String.valueOf(Math.random()));
            if (i % 2 == 0){
                log.info("i:{},key:{},content:{}",i,TopicMQConfig.TOPIC_QUEUE_NAME_TWO,concatMessage);
                rabbitTemplate.convertAndSend(TopicMQConfig.TOPIC_EXCHANGE_NAME, TopicMQConfig.TOPIC_ROUTING_KEY_ONE,String.valueOf(i));
            }else {
                log.info("i:{},key:{},content:{}",i,TopicMQConfig.TOPIC_ROUTING_KEY_TWO,concatMessage);
                rabbitTemplate.convertAndSend(TopicMQConfig.TOPIC_EXCHANGE_NAME,TopicMQConfig.TOPIC_ROUTING_KEY_TWO,String.valueOf(i));
            }
        }
    }
}
