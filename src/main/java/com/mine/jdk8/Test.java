package com.mine.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
//		InterfaceDemo id = new InterfaceDemo() {
//			@Override
//			public double cal(int a) {
//				return sqrt(a * 100);
//			}
//		};
//		
//		
//		System.out.println(id.cal(100));
//		System.out.println(id.sqrt(16));
		
//		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//		Collections.sort(names, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
//		
//		Collections.sort(names, (String a, String b) -> {
//			return a.compareTo(b);
//		});
//		
//		Collections.sort(names, (String x, String y) -> x.compareTo(y));
		
//		Converter<String, Integer> conv = (from) -> Integer.parseInt(from);
//		Integer c = conv.convert("123a");
//		System.out.println(c);
//		
//		Converter<String, Integer> conv2 = new Converter<String, Integer>() {
//			@Override
//			public Integer convert(String from) {
//				return Integer.parseInt(from);
//			}
//		};
//		Integer c2 = conv2.convert("123");
//		System.out.println(c2);
		
		
//		PersonFactory<Person> pf = Person::new;
//		Person p = pf.create("W", "bb");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");

		map.forEach((key, value) -> {
			System.out.println(value);
		});
		
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3));
		
	}

}
