package com.thread;

public class InterruptThreadDemo {

	public static void main(String[] args) {
		test1();

		test2();
	}

	private static void test2() {
		try {
			Thread t = new ThreadC();
			t.start();
			Thread.sleep(2000);
			t.interrupt();

			System.out.println(t.interrupted());
			System.out.println(t.interrupted());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void test1() {
		try {
			ThreadB t = new ThreadB();
			t.start();

			t.sleep(1000);
			t.doStop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ThreadB extends Thread {

	private volatile Thread blinker;

	public void doStop() {

		Thread tempThread = blinker;

		blinker = null;

		if (tempThread != null) {
			tempThread.interrupt();
		}

	}

	@Override
	public void run() {
		int i = 0;
		Thread thisThread = Thread.currentThread();
		while (blinker != thisThread) {
			try {
				i++;
				System.out.println(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

class ThreadC extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 500000; i++) {

		}
	}

}
