package com.orderfood.util;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

/***
 * 消息队列发送消息工具类
 */
@Component
public class MqUtils {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    /***
     * 发送队列模式消息 test
     */
    public void sendQueueMessage(String target,Object message){
        Queue queue=new ActiveMQQueue(target); //生成队列
        jmsMessagingTemplate.convertAndSend(queue,message);//往队列中放入消息
    }

    /**
     * 发布订阅 发送队列模式消息 test target为消息指定一个名字, message发送的信息 他两类似键和值
     */
    public void sendTopicMessage(String target,Object message){
        Topic topic=new ActiveMQTopic(target); //生成队列
        jmsMessagingTemplate.convertAndSend(topic,message);//往队列中放入消息
    }
}
