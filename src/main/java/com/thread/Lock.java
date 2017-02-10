package com.thread;

/**
 * 
 * <p>
 * 描述：
 * 1、非静态方法使用synchronized修饰，相当于synchronized(this)
 * 2、静态方法使用synchronized修饰，相当于synchronized(Lock.class)
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月7日
 *
 */
public class Lock {

	private static Object o = new Object();
	static Lock lock = new Lock();

	public synchronized void dynamicMethod() {
		System.out.println("dynamic method");
		sleepSilently(2000);
	}

	public synchronized static void staticMethod() {
		System.out.println("static method");
		sleepSilently(2000);
	}

	public void thisBlock() {
		synchronized (this) {
			System.out.println("this block");
			sleepSilently(2000);
		}
	}

	public void objectBlock() {
		synchronized (o) {
			System.out.println("object block");
			sleepSilently(2000);
		}
	}

	public static void classBlock() {
		synchronized (Lock.class) {
			System.out.println("class block");
			sleepSilently(2000);
		}
	}

	private static void sleepSilently(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// object lock
		new Thread(() -> {
			lock.dynamicMethod();
		}).start();
		new Thread(() -> {
			lock.objectBlock();
		}).start();
		new Thread(() -> {
			lock.thisBlock();
		}).start();
		
		sleepSilently(3000);
        System.out.println();
		
		// class lock
		new Thread(() -> {
			lock.staticMethod();
		}).start();
		new Thread(() -> {
			lock.classBlock();
		}).start();
		
	}

}
