package com.sestar.userserviceclient.jms.activemq;

//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQTextMessage;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.Destination;
//import javax.jms.Message;
//import javax.jms.MessageConsumer;
//import javax.jms.MessageProducer;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
///**
// * @description 自定义ActiveMQ
// * @author zhangxinxin
// * @date 2019/3/26 20:56
// **/
public class ActiveMQ {
//
//    private static final String BROKER_URL = "tcp://localhost:61616";
//
//    private static final String DESTINATION = "test";
//
//    public static void main(String[] args) throws Exception {
////        sendMessage();
//
//        receviceMessage();
//    }
//
//    /**
//     * @description 生产消息
//     * @author zhangxinxin
//     * @date 2019/3/26 21:09
//     */
//    private static void sendMessage() throws Exception {
//        // 创建链接
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
//        // 创建 jms 链接
//        Connection connection = connectionFactory.createConnection();
//        // 创建会话
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        // 创建消息目的
//        Destination destination = session.createQueue(DESTINATION);
//        // 创建消息生产者
//        MessageProducer producer = session.createProducer(destination);
//        // 创建消息
//        TextMessage message = new ActiveMQTextMessage();
//        message.setText("Hello World");
//        // 发送消息
//        producer.send(message);
//        System.out.println(ActiveMQ.class.getName() + "#sendMessage 生产消息：" + message.getText());
//
//        // 关闭生产者
//        producer.close();
//        // 关闭会话
//        session.close();
//        // 关闭 jms 链接
//        connection.close();
//    }
//
//    /**
//     * @description 消费消息
//     * @author zhangxinxin
//     * @date 2019/3/26 21:13
//     */
//    private static void receviceMessage() throws Exception {
//        // 创建 ActiveMQ 链接
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
//        // 创建 jms 链接
//        Connection connection = connectionFactory.createConnection();
//        // 启动链接
//        connection.start();
//        // 创建会话
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        // 创建消息目的
//        Destination destination = session.createQueue(DESTINATION);
//        // 创建消息消费者
//        MessageConsumer consumer = session.createConsumer(destination);
//        // 消费消息
//        Message message = consumer.receive(100);
//        if (message instanceof TextMessage) {
//            TextMessage textMessage = (TextMessage) message;
//            System.out.println(ActiveMQ.class.getName() + "#receviceMessage 消费消息：" + textMessage.getText());
//        }
//    }
//
}
