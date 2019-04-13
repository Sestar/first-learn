package com.sestar.streambinderactivemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.Binder;
import org.springframework.cloud.stream.binder.Binding;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.Assert;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @description Active MQ Message Channel Binder
 * @author zhangxinxin
 * @date 2019/3/29 14:52
 **/
public class ActiveMQMessageChannelBinder implements Binder<MessageChannel, ConsumerProperties, ProducerProperties> {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * @description 生产消息
     * @author zhangxinxin
     * @date 2019/3/29 14:54
     * @param name topic
     * @param outboundBindTarget 消息管道
     * @param producerProperties 生产者配置
     * @return org.springframework.cloud.stream.binder.Binding<org.springframework.messaging.MessageChannel>
     */
    @Override
    public Binding<MessageChannel> bindProducer(String name, MessageChannel outboundBindTarget, ProducerProperties producerProperties) {
        Assert.isInstanceOf(SubscribableChannel.class, outboundBindTarget,
                "Binding is supported only for SubscribableChannel instances");
        SubscribableChannel subscribableChannel = (SubscribableChannel) outboundBindTarget;

        subscribableChannel.subscribe(message -> {
            Object messageBody = message.getPayload();
            System.out.println(ActiveMQMessageChannelBinder.class.getName() + "#bindProducer 生产消息: " + messageBody);
            // 生产消息的目的为 name, 即 application.properties 中 default-destination
            jmsTemplate.convertAndSend(name, messageBody);
        });

        return () -> System.out.println(ActiveMQMessageChannelBinder.class.getName() + "#bindProducer Unbinding MessageChannel");
    }

    /**
     * @description 消费消息
     * @author zhangxinxin
     * @date 2019/3/29 14:54
     * @param name topic
     * @param group consumer-group
     * @param inboundBindTarget 消息管道
     * @param consumerProperties 消费者配置
     * @return org.springframework.cloud.stream.binder.Binding<org.springframework.messaging.MessageChannel>
     */
    @Override
    public Binding<MessageChannel> bindConsumer(String name, String group, MessageChannel inboundBindTarget, ConsumerProperties consumerProperties) {
        try {
            ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory();
            // 创建 jms 链接
            Connection connection = connectionFactory.createConnection();
            // 启动链接
            connection.start();
            // 创建会话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 创建消息目的
            Destination destination = session.createQueue(name);
            // 创建消息消费者
            MessageConsumer consumer = session.createConsumer(destination);
            // 消费消息
            consumer.setMessageListener(message -> {
                // message 来自于 ActiveMQ
                if (message instanceof ObjectMessage) {
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    try {
                        Object object = objectMessage.getObject();
                        System.out.println(ActiveMQMessageChannelBinder.class.getName() + "#bindConsumer 消费消息: " + object);
                        // 订阅消息目的为 inboundBindTarget 绑定的topic, application.properties 中设置
                        inboundBindTarget.send(new GenericMessage<>(object), 100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
