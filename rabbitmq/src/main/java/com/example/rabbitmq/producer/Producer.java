package com.example.rabbitmq.producer;

import com.example.rabbitmq.config.DirectMQConfig;
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
     * @description: work queue模型
     * @Param:
     * @author: wzq
     * @date: 2021/7/6 3:59 下午
     */
    @GetMapping("/work/sendMessage")
    public void sendMessageToWork(String message){
        for (int i = 0; i < 8; i++) {
            String concatMessage = message.concat(String.valueOf(Math.random()));
            log.info("message:{}",concatMessage);
            rabbitTemplate.convertAndSend(DirectMQConfig.DIRECT_EXCHANGE_NAME,DirectMQConfig.DIRECT_ROUTING_KEY_NAME,concatMessage);
        }
    }

    @GetMapping("/subscribe/sendMessage")
    public void sendMessageToPublishAndSubscribe(String message){
        for (int i = 0; i < 8; i++) {
            String concatMessage = message.concat(String.valueOf(Math.random()));
            log.info("message:{}",concatMessage);
            rabbitTemplate.convertAndSend(null,concatMessage);
        }
    }
}
