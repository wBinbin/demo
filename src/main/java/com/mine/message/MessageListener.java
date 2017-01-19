package com.mine.message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageListener implements MessageProcess {

	private ArrayBlockingQueue queue;

	public MessageListener(ArrayBlockingQueue queue) {
		this.queue = queue;
	}

	public void generateMessage() {

	}

	@Override
	public void doMessage(Message msg) {

	}

	public static void main(String[] args) {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(20);
		ExecutorService pools = Executors.newFixedThreadPool(2);
		
		pools.execute(() -> {
			try {
				for (int i = 0; i < 30; i++) {
					queue.put("" + i);
					System.out.println("put " + "" + i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		pools.execute(() -> {
			try {
				while (true) {
					System.out.println("take " + queue.take());
					Thread.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}

}
