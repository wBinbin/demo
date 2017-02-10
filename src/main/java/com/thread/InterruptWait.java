package com.thread;

/**
 * 
 * <p>
 * 描述：?
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月7日
 *
 */
public class InterruptWait extends Thread {

	public static Object lock = new Object();

	@Override
	public void run() {
		System.out.println("start");
		synchronized (lock) {
			try {
				System.out.println("wait");
				lock.wait();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println(Thread.currentThread().isInterrupted());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread c = new InterruptWait();
		c.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.interrupt();
	}

}
