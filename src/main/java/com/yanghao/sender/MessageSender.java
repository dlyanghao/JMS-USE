package com.yanghao.sender;


import com.yanghao.core.JMessageCreator;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import static java.lang.Thread.sleep;

/**
 * 消息发送者
 */
public class MessageSender {

    public void send(){

        //创建工厂
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Spring 提供的java message server 模板对象
        JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");

        //消息队列控制器
        ActiveMQQueue mqQueue = (ActiveMQQueue) applicationContext.getBean("mqQueue");

        //模拟消息发送者不断发送消息
        for (int i = 1;i<100;i++){
            //创建核心消息创建者
            JMessageCreator jMessageCreator = new JMessageCreator();
            jMessageCreator.setMessage("我爱发消息！");
            jmsTemplate.send(mqQueue,jMessageCreator);
            //控制5秒后发送下一条消息
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
