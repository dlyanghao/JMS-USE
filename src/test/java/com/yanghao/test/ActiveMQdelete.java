package com.yanghao.test;

import com.yanghao.sender.MessageSender;
import com.yanghao.receiver.MessagaReceiver;
import org.junit.Test;

import javax.jms.JMSException;

public class ActiveMQTest {

    @Test
    public void test() throws JMSException {
        final MessageSender messageSender = new MessageSender();
        //开启一个线程模拟循环发送消息
        new Thread(new Runnable() {
            @Override
            public void run() {
                messageSender.send();
            }
        }).start();
        //开启消息接受者
        MessagaReceiver messagaReceiver = new MessagaReceiver();
        messagaReceiver.received();

    }
}
