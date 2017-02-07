package com.calculte;

public class IntegerSubtract extends AbstractIntegerCalcultor {

	@Override
	public int calculte(int a, int b) {
		return a - b;
	}
	
	public static void main(String[] args) {
		AbstractIntegerCalcultor cal = new IntegerSubtract();
		int r = cal.calculte("2-30", "\\-");
		System.out.println(r);
	}

}
