package com.mine;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	public static void main(String[] args) {

		try {
			ExecutorService p1 = Executors.newSingleThreadExecutor();
			ExecutorService p2 = Executors.newSingleThreadExecutor();

			Future<Integer> f1 = p1.submit(new MyCallable(1));
			Future<Integer> f2 = p2.submit(new MyCallable(10));

			System.out.println(f1.isDone() + " -> " + f1.get());
			System.out.println(f1.isDone() + " -> " + f2.get());

			p1.shutdown();
			p2.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class MyCallable implements Callable<Integer> {

	private Integer num;

	MyCallable(Integer num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		num++;
		System.out.println("+");
		
		Thread.sleep(1000);
		
		return num;
	}

}
