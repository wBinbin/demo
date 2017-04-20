package com.mq.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Subscribe {
	
	public void receive(String subscribeName, String exchange, String[] routingKeyArray) {
		System.out.println("Subscribe " + subscribeName + " start receive. ");
		Connection connection = null;
		Channel channel = null;
		try {
			connection = ConnectionManeger.init().newConnection();
			channel = connection.createChannel();
			
			channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);
			
			String queueName = channel.queueDeclare().getQueue();
			for (String routingKey : routingKeyArray) {
				channel.queueBind(queueName, exchange, routingKey);
			}
			
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String msg = new String(body, "UTF-8");
					System.out.println(" [" + subscribeName + "] Received '" + msg + "'");
				}
			};
			channel.basicConsume(queueName, true, consumer);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
