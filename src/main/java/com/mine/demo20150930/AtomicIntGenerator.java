package com.mine.demo20150930;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicIntGenerator {

	private final AtomicIntegerMine counter = new AtomicIntegerMine(0);

	public int getNext() {
		return counter.getAndIncrementa();
	}

	public static void main(String[] args) {
//		AtomicIntGenerator g = new AtomicIntGenerator();
//		new Thread(() -> {
//
//			for (int i = 0; i < 20; i++) {
//				System.out.println(Thread.currentThread().getName() + " -> " + g.getNext());
//			}
//
//		}).start();
//
//		new Thread(() -> {
//
//			for (int i = 0; i < 20; i++) {
//				System.out.println(Thread.currentThread().getName() + " -> " + g.getNext());
//			}
//
//		}).start();
//		
//		new Thread(() -> {
//
//			for (int i = 0; i < 20; i++) {
//				System.out.println(Thread.currentThread().getName() + " -> " + g.getNext());
//			}
//
//		}).start();
//		
//		new Thread(() -> {
//
//			for (int i = 0; i < 20; i++) {
//				System.out.println(Thread.currentThread().getName() + " -> " + g.getNext());
//			}
//
//		}).start();
		
	}

}
