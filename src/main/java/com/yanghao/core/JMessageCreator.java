package com.yanghao.core;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;





/**
 * 消息核心创建器
 */
public class JMessageCreator implements MessageCreator{

    //消息内容
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(message);
    }
}
