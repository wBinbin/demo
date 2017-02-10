package com.thread;

public class ThreadLocalUsage extends Thread {
	
	public User user = new User();

	public User getUser() {
		return user;
	}

	@Override
	public void run() {
		this.user.set("var1");

		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {

			}
			this.user.get();
		}
	}
	
	public static void main(String[] args) {

		ThreadLocalUsage thread = new ThreadLocalUsage();
		thread.start();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

		}

		thread.getUser().set("var2");
		thread.user.get();
	}

}

class User {

	// is it must be static?
	private static ThreadLocal<Object> enclosure = new ThreadLocal<Object>();

	public void set(Object object) {
		enclosure.set(object);
		System.out.println(enclosure.hashCode() + " -> " + object);
	}

	public Object get() {
		System.out.println(enclosure.hashCode() + " <- " + enclosure.get());
		return enclosure.get();
	}
}