package com.mine;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

	@Override
	public int compare(String orderCodeA, String orderCodeB) {
		if (orderCodeA.startsWith("0")) {
			orderCodeA = String.format("1%s", orderCodeA);
		}
		if (orderCodeB.startsWith("0")) {
			orderCodeB = String.format("1%s", orderCodeB);
		}
		return Long.valueOf(orderCodeB).compareTo(Long.valueOf(orderCodeA));
	}

}
