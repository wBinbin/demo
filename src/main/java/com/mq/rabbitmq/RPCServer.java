package com.mq.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class RPCServer {
	
	public static void main(String[] args) {
		RPCServer rpcServer = new RPCServer();
		rpcServer.server();
	}

	private void server() {
		try {
			Connection connection = ConnectionManeger.init().newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(ConnectionManeger.QUEUE_NAME, false, false, false, null);
			channel.basicQos(1);
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					BasicProperties pro = new BasicProperties().builder().correlationId(properties.getAppId()).build();
					String response = "";
					
					
					
				}
			};
			channel.basicConsume(ConnectionManeger.QUEUE_NAME, false, consumer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
	}

}
