package com.company;

import org.apache.activemq.ActiveMQConnectionFactory;
import view.JMSWindow;

import javax.jms.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JMSApp {
    private static JMSWindow jmsWindow;
    private static ActiveMQConnectionFactory connectionFactory;
    private static Connection connection;
    private static Session session;
    private static Destination destination;
    private static String queue;


    public static void main(String[] args) {
        jmsWindow = new JMSWindow();
        jmsWindow.setVisible(true);

        //Отправить сообщение
        jmsWindow.jBSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickSendButton();
            }
        });

        //Получить сообщение
        jmsWindow.jBConnectedListener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickReceivedButton();
            }
        });

        jmsWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(connection != null){
                    try {
                        connection.close();
                    }
                    catch (JMSException exception){
                        System.out.println(exception.getLinkedException());
                        System.out.println(JMSApp.class.getName());
                    }
                }
            }
        });
    }

    public static Boolean connected(){
        try {
            if(connection == null){
                connectionFactory = getConnectionFactory();
                connection = connectionFactory.createConnection();
                connection.start();
                session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            }
            else {
                connection.start();
            }
            return true;
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return false;
        }
    }

    public static void clickSendButton() {
        queue = jmsWindow.getQueueSendName().equals("") ? "SimpleQueue" : jmsWindow.getQueueSendName();
        if(connected() && !jmsWindow.getMessageSendText().equals("")){
            jmsWindow.SendConnectedSucces();
            if(jmsWindow.isPtP()){
                destination = getDestinationQueue();
            }
            else {
                destination = getDestinationTopic();
            }
            if(destination != null){
                try {
                    MessageProducer producer = session.createProducer(destination);
                    producer.setDeliveryMode(DeliveryMode.PERSISTENT);
                    TextMessage message = session.createTextMessage(jmsWindow.getMessageSendText());
                    producer.send(message);
                    jmsWindow.SendSuccess();
                }
                catch (JMSException exception){
                    jmsWindow.SendError();
                    System.out.println(exception.getLinkedException());
                    System.out.println(JMSApp.class.getName());
                }
            }
            else {
                jmsWindow.SendError();
            }
        }
        else {
            jmsWindow.SendError();
        }
    }

    public static void clickReceivedButton() {
        queue = jmsWindow.getQueueSendName().equals("") ? "SimpleQueue" : jmsWindow.getQueueSendName();
        if(connected() && !jmsWindow.getMessageSendText().equals("")){
            jmsWindow.SendConnectedSucces();
            if(jmsWindow.isPtP()){
                destination = getDestinationQueue();
            }
            else {
                destination = getDestinationTopic();
            }
            if(destination != null){
                try {
                    MessageConsumer consumer = session.createConsumer(destination);
                    consumer.setMessageListener(new MessageListener() {
                        @Override
                        public void onMessage(Message message) {

                            TextMessage textMessage = (TextMessage) message;
                            try {
                                jmsWindow.setTextReceiver(textMessage.getText());
                            }
                            catch (JMSException exception){
                                System.out.println(exception.getLinkedException());
                                System.out.println(JMSApp.class.getName());
                            }
                        }
                    });
                    jmsWindow.ReceivedConnectedSucces();
                }
                catch (JMSException exception){
                    jmsWindow.SendError();
                    System.out.println(exception.getLinkedException());
                    System.out.println(JMSApp.class.getName());
                }
            }
            else {
                jmsWindow.SendError();
            }
        }
        else {
            jmsWindow.SendError();
        }
    }

    //embedded broker ?
    private static ActiveMQConnectionFactory getConnectionFactory(){
        return new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "failover://tcp://localhost:61616");
    }

    //Подключаемся к модели точка-точка
    private static Destination getDestinationQueue(){
        try {
            return session.createQueue(queue);
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return null;
        }
    }

    //Подключаемся к модели подписчик-издатель
    private static Destination getDestinationTopic(){
        try {
            return session.createTopic(queue);
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return null;
        }
    }
}
