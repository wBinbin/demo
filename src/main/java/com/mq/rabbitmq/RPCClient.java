package com.mq.rabbitmq;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RPCClient {

	private Connection connection;
	private Channel channel;
	private String replyQueueName;

	public RPCClient() throws IOException, TimeoutException {
		connection = ConnectionManeger.init().newConnection();
		channel = connection.createChannel();
		DeclareOk declareOk = channel.queueDeclare(ConnectionManeger.RPC_QUEUE_NAME, false, false, false, null);

		replyQueueName = declareOk.getQueue();
	}

	public String call(String message) throws IOException, InterruptedException {
		final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);

		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		BasicProperties props = new BasicProperties().builder().correlationId(uuid).replyTo(replyQueueName).build();

		channel.basicPublish("", ConnectionManeger.RPC_QUEUE_NAME, props, message.getBytes("UTF-8"));

		channel.basicConsume(ConnectionManeger.RPC_QUEUE_NAME, true, new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
				if (properties.getCorrelationId().equals(uuid)) {
					response.offer(new String(body, "UTF-8"));
				}
			}
		});
		return response.take();
	}

	public void close() {
		try {
			if (channel != null) {
				channel.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
