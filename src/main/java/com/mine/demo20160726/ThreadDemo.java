package com.mine.demo20160726;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {

	public static void main(String[] args) {
		System.out.println("Main Thread");

		new T1().start();

		new Thread(new T2()).start();

		ExecutorService pool = Executors.newFixedThreadPool(3);
		List<Future<Object>> list = new ArrayList<Future<Object>>();
		for (int i = 0; i < 3; i++) {
			Future<Object> f = (Future<Object>) pool.submit(new T3("MyT3-" + i));
			list.add(f);
		}
		pool.shutdown();

		try {
			for (Future<Object> f : list) {
				System.out.println(((Data) f.get()).getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class T1 extends Thread {

	@Override
	public void run() {
		System.out.println("Sub Thread, Extends Thread");
	}

}

class T2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Sub Thread, Implements Runnable");
	}

}

class T3 implements Callable<Object> {

	private String name;

	public T3(String name) {
		this.name = name;
	}

	@Override
	public Data call() throws Exception {
		Data d = new Data();
		d.setName(name);
		return d;
	}

}

class Data {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
