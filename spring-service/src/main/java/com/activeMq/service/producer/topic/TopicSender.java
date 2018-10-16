package com.activeMq.service.producer.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
@Component
public class TopicSender {
    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTemplate;
    /*
    * @param topicName 主题名称
    * @param message 消息内容
    * @return void 返回值
    * * */
    public void send(String topicName,final String message){
        jmsTemplate.send(topicName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
