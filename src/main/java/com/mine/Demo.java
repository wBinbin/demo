package com.mine;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Demo {

	public static void main(String[] args) {
//		System.out.println(fib(1));
//		System.out.println(fib(2));
//		System.out.println(fib(3));
//		System.out.println(fib(4));
//		System.out.println(fib(5));
//		System.out.println(fib(6));

//		System.out.println(fib(1, 0, 1));
//		System.out.println(fib(1, 0, 2));
//		System.out.println(fib(1, 0, 3));
//		System.out.println(fib(1, 0, 4));
//		System.out.println(fib(1, 0, 5));
//		System.out.println(fib(1, 0, 6));
//		System.out.println(fib(1, 0, 7));
		
//		LinkedList<String> list = new LinkedList<String>();
//		List<String> l = Arrays.asList(new String[]{"a", "b"});
//		list.addAll(l);
//		
//		System.out.println();
		
		
		Map<String, String> map = new TreeMap<String, String>(new MyComparator());
		map.put("01", "01");
		map.put("51", "51");
		map.put("21", "21");
		map.put("11", "11");
		for (Iterator<String> ite = map.keySet().iterator(); ite.hasNext();) {
			String key = ite.next();
			System.out.println(key + " -> " + map.get(key));
		}
		
	}

	static int fib(int n) {
		if (n < 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	static int fib(int a, int b, int n) {
		if (n == 0)
			return a;
		else
			return fib(a + b, a, n - 1);
	}

}
