package com.mine.demo20150929;

public class IteratorDemo {

	public static void main(String[] args) {
		Collection collection = new List();
		Iterator it = collection.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
