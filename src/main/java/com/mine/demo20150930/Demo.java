package com.mine.demo20150930;

public class Demo {

	private static boolean flag;

	public static void main(String[] args) {
		new Thread(() -> {
			flag = false;
			while (!flag) {
				System.out.println("flag");
			}
			System.out.println("flag true");
		}).start();

		new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			flag = true;
			System.out.println("set flag");
		}).start();
	}

}
