package com.mq.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RPCServer {

	public void server() {
		try {
			Connection connection = ConnectionManeger.init().newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(ConnectionManeger.RPC_QUEUE_NAME, false, false, false, null);
			channel.basicQos(1);
			
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
					BasicProperties replyProps = new BasicProperties().builder().correlationId(properties.getCorrelationId()).build();
					String response = "";
					
					try {
						String message = new String(body, "UTF-8");
						int n = Integer.parseInt(message);
						int m = fib(n);
						System.out.println("RPCServer fib(" + n + ") = " + m);
						
						response = String.valueOf(m);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						channel.basicPublish("", properties.getReplyTo(), replyProps, response.getBytes());
						channel.basicAck(envelope.getDeliveryTag(), false);
					}
				}

			};
			channel.basicConsume(ConnectionManeger.RPC_QUEUE_NAME, false, consumer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	private static int fib(int n) {
		return n + 1;
	}

}
