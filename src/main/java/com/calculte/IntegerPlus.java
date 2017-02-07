package com.calculte;


public class IntegerPlus extends AbstractIntegerCalcultor {

	@Override
	public int calculte(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		AbstractIntegerCalcultor cal = new IntegerPlus();
		int r = cal.calculte("2+3", "\\+");
		System.out.println(r);
	}

}
