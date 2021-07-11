package com.example.rabbitmq.consumer;

import com.example.rabbitmq.config.WorkMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wzq
 * @Date 2021/7/11
 * work queue模型，任务在多个消费者之间共享，但是一个消息只能被一个消费者获取。
 **/
@Slf4j
@Configuration
public class WorkQueueListener {


    @RabbitListener(queues = WorkMQConfig.WORK_QUEUE_NAME)
    public void workProcessOne(Message message){
        String content = new String(message.getBody());
        log.info("process one:"+content);
    }

    @RabbitListener(queues = WorkMQConfig.WORK_QUEUE_NAME)
    public void workProcessTwo(Message message){
        String content = new String(message.getBody());
        log.info("process two:"+content);
    }
}
