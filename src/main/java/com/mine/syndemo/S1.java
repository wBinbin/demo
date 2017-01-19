package com.mine.syndemo;

public class S1 {

	private Integer i = 0;

	public void add() {
		synchronized (i) {
			System.out.println("开始add");
			try {
				Thread.sleep(3000);
				i = i + 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("结束add");
		}
	}

	public void sub() {
		synchronized (i) {
			System.out.println("开始sub");
			i = i - 1;
			System.out.println("结束sub");
		}
	}

	public static void main(String[] args) {
		S1 s = new S1();

		System.out.println("开始");
		
		new Thread(() -> {
			s.add();
		}).start();

		new Thread(() -> {
			s.sub();
		}).start();

	}

}
