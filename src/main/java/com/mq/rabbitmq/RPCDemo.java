package com.mq.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RPCDemo {

	public static void main(String[] args) {
		new Thread(() -> {
			RPCServer server = new RPCServer();
			server.server();
		}).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(() -> {
			try {
				RPCClient client = new RPCClient();
				System.out.println("fib(5) result = " + client.call("5"));
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(() -> {
			try {
				RPCClient client = new RPCClient();
				System.out.println("fib(10) result = " + client.call("10"));
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
