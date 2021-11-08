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

    private static Session sessionProducer;
    private static Session sessionConsumer;
    private static Connection connectionProducer;
    private static Connection connectionConsumer;

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
                if(connectionProducer != null){
                    try {
                        connectionProducer.close();
                    }
                    catch (JMSException exception){
                        System.out.println(exception.getLinkedException());
                        System.out.println(JMSApp.class.getName());
                    }
                }
                if(connectionConsumer != null){
                    try {
                        connectionConsumer.close();
                    }
                    catch (JMSException exception){
                        System.out.println(exception.getLinkedException());
                        System.out.println(JMSApp.class.getName());
                    }
                }
            }
        });


    }

    public static Boolean connectedProducer(){
        try {
            if(connectionProducer == null){
                connectionFactory = getConnectionFactory();
                connectionProducer = connectionFactory.createConnection();
                connectionProducer.start();
                int sessionCode = Integer.parseInt(jmsWindow.buttonGroup_1.getSelection().getActionCommand());
                if(sessionCode > 0){
                    sessionProducer = connectionProducer.createSession(false, sessionCode);
                }
                else {
                    sessionProducer = connectionProducer.createSession(true, 0);
                }
            }
            else {
                connectionProducer.start();
            }
            return true;
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return false;
        }
    }

    public static Boolean connectedConsumer(){
        try {
            if(connectionConsumer == null){
                connectionFactory = getConnectionFactory();
                connectionConsumer = connectionFactory.createConnection();
                connectionConsumer.start();
                int sessionCode = Integer.parseInt(jmsWindow.buttonGroup_1.getSelection().getActionCommand());
                if(sessionCode > 0){
                    sessionConsumer = connectionConsumer.createSession(false, sessionCode);
                }
                else {
                    sessionConsumer = connectionConsumer.createSession(true, 0);
                }
            }
            else {
                connectionConsumer.start();
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
        if(connectedProducer() && !jmsWindow.getMessageSendText().equals("")){
            jmsWindow.SendConnectedSucces();
            if(jmsWindow.isPtP()){
                destination = getDestinationQueueProducer();
            }
            else {
                destination = getDestinationTopicProducer();
            }
            if(destination != null){
                try {
                    System.out.println("INFO sessionProducer");
                    System.out.println("getAcknowledgeMode = " + sessionProducer.getAcknowledgeMode());
                    System.out.println("getMessageListener = " + sessionProducer.getMessageListener());
                    System.out.println("getTransacted = " + sessionProducer.getTransacted());
                    MessageProducer producer = sessionProducer.createProducer(destination);
                    int persistent = Integer.parseInt(jmsWindow.buttonGroup_2.getSelection().getActionCommand());
                    producer.setDeliveryMode(persistent);
                    TextMessage message = sessionProducer.createTextMessage(jmsWindow.getMessageSendText());
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
        if(connectedConsumer() && !jmsWindow.getMessageSendText().equals("")){
            jmsWindow.SendConnectedSucces();
            if(jmsWindow.isPtP()){
                destination = getDestinationQueueConsumer();
            }
            else {
                destination = getDestinationTopicConsumer();
            }
            if(destination != null){
                try {
                    System.out.println("INFO sessionConsumer");
                    System.out.println("getAcknowledgeMode = " + sessionConsumer.getAcknowledgeMode());
                    System.out.println("getMessageListener = " + sessionConsumer.getMessageListener());
                    System.out.println("getTransacted = " + sessionConsumer.getTransacted());
                    MessageConsumer consumer = sessionConsumer.createConsumer(destination);
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

    private static ActiveMQConnectionFactory getConnectionFactory(){
        if(jmsWindow.chckbxNewCheckBox.isSelected()){
            jmsWindow.chckbxNewCheckBox.setEnabled(false);
            return new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        }
        else {
            jmsWindow.chckbxNewCheckBox.setEnabled(false);
            return new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "failover://tcp://localhost:61616");
        }
    }

    //Подключаемся к модели точка-точка
    private static Destination getDestinationQueueProducer(){
        try {
            return sessionProducer.createQueue(queue);
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return null;
        }
    }

    //Подключаемся к модели подписчик-издатель
    private static Destination getDestinationTopicProducer(){
        try {
            return sessionProducer.createTopic(queue);
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return null;
        }
    }


    //Подключаемся к модели точка-точка
    private static Destination getDestinationQueueConsumer(){
        try {
            return sessionConsumer.createQueue(queue);
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return null;
        }
    }

    //Подключаемся к модели подписчик-издатель
    private static Destination getDestinationTopicConsumer(){
        try {
            return sessionConsumer.createTopic(queue);
        }
        catch (JMSException exception){
            System.out.println(exception.getLinkedException());
            System.out.println(JMSApp.class.getName());
            return null;
        }
    }
}
