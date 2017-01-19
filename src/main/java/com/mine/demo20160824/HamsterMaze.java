package com.mine.demo20160824;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Think in java. 8.1 枚举器
 * 
 * @Author Patrick 魏彬彬
 * @Date 2016年8月24日
 *
 */
public class HamsterMaze {
	
	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i = 0; i < 3; i++) {
			v.addElement(new Hamster(i));
		}
		Printer.printAll(v.elements());
	}

}

class Hamster {

	private int num;

	public Hamster(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Hamster Num : " + num;
	}

}

class Printer {

	public static void printAll(Enumeration e) {
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement().toString());
		}
	}

}
