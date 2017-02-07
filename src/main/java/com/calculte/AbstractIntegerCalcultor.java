package com.calculte;

public abstract class AbstractIntegerCalcultor {

	public final int calculte(String exp, String opt) {
		int array[] = split(exp, opt);
		return calculte(array[0], array[1]);
	}

	private int[] split(String exp, String opt) {
		String array[] = exp.split(opt);

		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);

		return arrayInt;
	}

	abstract public int calculte(int a, int b);

}
