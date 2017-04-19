package com.mq.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

public class ConnectionManeger {
	
	public static final String EXCHANGE_NAME = "log";

	public static final String QUEUE_NAME = "hello";

	private static Object lock = new Object();

	private static ConnectionFactory factory = null;

	public static ConnectionFactory init() {
		synchronized (lock) {
			if (factory == null) {
				factory = new ConnectionFactory();
				factory.setHost("localhost");
				// factory.setPort(port);
			}
		}
		return factory;
	}
	
}
