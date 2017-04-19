package com.mq.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Publish {

	public static void main(String[] args) {
		Publish p1 = new Publish();
		p1.send("123456789");
	}

	private void send(String msg) {
		Connection connection = null;
		Channel channel = null;
		try {
			connection = ConnectionManeger.init().newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare(ConnectionManeger.EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

			channel.basicPublish(ConnectionManeger.EXCHANGE_NAME, "", null, msg.getBytes());

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
