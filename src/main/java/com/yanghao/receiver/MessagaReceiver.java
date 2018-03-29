package com.yanghao.receiver;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 消息接收者
 */
public class MessagaReceiver {

    private TextMessage message;

    public void received() throws JMSException {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate)applicationContext.getBean("jmsTemplate");
        ActiveMQQueue activeMQQueue = (ActiveMQQueue) applicationContext.getBean("mqQueue");

        //接收消息并打印
        int count = 0;
        while (count<=100){
            TextMessage receive = (TextMessage)jmsTemplate.receive(activeMQQueue);
            System.out.println(receive.getText());
            count++;
        }
    }
}
