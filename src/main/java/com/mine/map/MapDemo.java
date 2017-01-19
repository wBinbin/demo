package com.mine.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapDemo {

	public static void main(String[] args) {
		i();
	}

	private static void i() {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < 5; i++) {
			map.put(i, "num_" + i);
		}

		Iterator<Integer> ite = map.keySet().iterator();
		while (ite.hasNext()) {
			Integer key = ite.next();

			if (key == 3) {
				System.out.println("delete. key=" + key);
				ite.remove();
			}
		}
		System.out.println(map);
		
		for (Entry<Integer, String> entry : map.entrySet()) {
			
		}
		
		map.remove(1);

	}

}
