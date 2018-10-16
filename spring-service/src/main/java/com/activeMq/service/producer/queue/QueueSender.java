package com.activeMq.service.producer.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class QueueSender {
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;
    /*
    * @param queueName 队列名称
    * @param message 消息内容
    * @return void 返回值
    * * */
    public void send(String queueName,final String message){
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            return session.createTextMessage(message);
                }
            });
    }
}
