package com.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * <p>
 * 描述：自定义比较器
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月6日
 *
 */
public class MyComparator implements Comparator<String> {

	@Override
	public int compare(String orderCodeA, String orderCodeB) {
			// 订单号开头0-9，表示1-10的数字（0=10）
		if (orderCodeA.startsWith("0")) {
			orderCodeA = String.format("1%s", orderCodeA);
		}
		if (orderCodeB.startsWith("0")) {
			orderCodeB = String.format("1%s", orderCodeB);
		}
		return Long.valueOf(orderCodeB).compareTo(Long.valueOf(orderCodeA));
	}
	
	public static void main(String[] args) {
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

}
