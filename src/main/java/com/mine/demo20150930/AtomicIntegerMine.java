package com.mine.demo20150930;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMine extends AtomicInteger {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2575070206122048911L;

	public AtomicIntegerMine(int i) {
		super(i);
	}

	public int getAndIncrementa() {
		for (;;) {
			int curr = get();
			int next = curr + 1;
			if (compareAndSet(curr, next)) {
				return next;
			}
		}
	}

}
