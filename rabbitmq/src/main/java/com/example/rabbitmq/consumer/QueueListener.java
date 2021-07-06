package com.example.rabbitmq.consumer;

import com.example.rabbitmq.config.DirectMQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author wzq
 * @Date 2021/7/6
 * @Description work queue 队列模型
 * @RabbitListener注解属性详解
 * 1.ackMode：消息确认模式 noack, auto, manual
 * 2.queues：监听的消息队列
 * 3.concurrency：并行消费 只有一个n值，表示固定4个消费，m-n，表示m个并行消费者，最多有n个
 **/
@Component
@Slf4j
public class QueueListener {

    /**
     * 简单队列模型
     */
    @RabbitListener(queues = "simple",ackMode = "MANUAL")
    public void simpleQueueListener(Message message,@Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        String messageStr = new String(message.getBody());
        log.info("message:{},deliveryTag:{}",messageStr,deliveryTag);

        //正确消费时调用 basicAck ；RabbitMQ的ack机制中，第二个参数返回true，表示需要将这条消息投递给其他的消费者重新消费
        channel.basicAck(deliveryTag,false);

        //消费失败时，调用 basicNack 需要将消息重新塞入队列，等待重新消费；第三个参数true，表示这个消息会重新进入队列
        //channel.basicNack(deliveryTag,false,true);

    }

    /**
     * 分发队列模型（work queue）
     */
    @RabbitListener(queues = DirectMQConfig.DIRECT_QUEUE_NAME,ackMode = "MANUAL",concurrency = "3")
    public void orkQueueListener(Message message
            , @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag
            , Channel channel) throws IOException {

        String messageStr = new String(message.getBody());
        log.info("messageStr:{},deliveryTag:{}",messageStr,deliveryTag);
        channel.basicAck(deliveryTag,false);

    }
}
