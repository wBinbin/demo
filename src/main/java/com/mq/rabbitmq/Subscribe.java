package com.mq.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Subscribe {
	
	public static void main(String[] args) {
		Subscribe s1 = new Subscribe();
		s1.receive();
	}

	private void receive() {
		Connection connection = null;
		Channel channel = null;
		try {
			connection = ConnectionManeger.init().newConnection();
			channel = connection.createChannel();
			
			channel.exchangeDeclare(ConnectionManeger.EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
			
			String queueName = channel.queueDeclare().getQueue();
			channel.queueBind(queueName, ConnectionManeger.EXCHANGE_NAME, "");
			
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String msg = new String(body, "UTF-8");
					System.out.println(" [x] Received '" + msg + "'");
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
