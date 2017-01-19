package com.mine.demo20150929;

public class Plus extends AbstractCalcultor {

	@Override
	public int calculte(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		AbstractCalcultor cal = new Plus();
		int r = cal.calculte("2+3", "\\+");
		System.out.println(r);
	}

}
