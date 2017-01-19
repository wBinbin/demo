package com.mine.demo20150929;

public class ObserverDemo {
	
	public static void main(String[] args) {
		Subject s = new MySubject();
		s.add(new ServerA());
		s.add(new ServerB());
		
		s.operation();
	}

}
