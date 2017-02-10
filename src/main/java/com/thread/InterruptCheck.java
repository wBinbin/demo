package com.thread;

public class InterruptCheck extends Thread {

	@Override
	public void run() {
		System.out.println("satrt");
		while (true) {
			System.out.println("while");
			if (Thread.currentThread().isInterrupted())
				break;
		}
		System.out.println("exit");
	}

	public static void main(String[] args) {
		Thread c = new InterruptCheck();
		c.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("interrupt");
		c.interrupt();
	}

}
