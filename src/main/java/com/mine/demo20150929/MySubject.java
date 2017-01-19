package com.mine.demo20150929;

public class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		System.out.println("update...");
		notifyObservers();
	}

}
