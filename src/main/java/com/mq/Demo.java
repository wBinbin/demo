package com.mq;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.util.TimeUtil;

public class Demo {
	
	public static void main(String[] args) {
//		new Thread(() -> {
//			for (int i = 0; i < 10; i++) {
//				producerDo();
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
//		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		consumerDo();
	}

	private static void consumerDo() {
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
			Connection connection = factory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("ActiveMQ-01");
			
			MessageConsumer consumer = session.createConsumer(destination);
			consumer.setMessageListener(new MyListner());
			
//			consumer.close();
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private static void producerDo() {
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
			Connection connection = factory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("ActiveMQ-01");
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			TextMessage message = session.createTextMessage("now time -> " + TimeUtil.dateToStr(new Date(), TimeUtil.YYYY_MM_DD_HH_MM_SS));
			
			producer.send(message);
			
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

class MyListner implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			System.out.println(textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
