package com.mq.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Publish {
	
	public void send(String publishName, String exchange, String routingKey, String msg) {
		System.out.println("Publish " + publishName + " start send. ");
		Connection connection = null;
		Channel channel = null;
		try {
			msg = " [" + publishName + "] " + msg;
			
			connection = ConnectionManeger.init().newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);

			channel.basicPublish(exchange, routingKey, null, msg.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
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

}
