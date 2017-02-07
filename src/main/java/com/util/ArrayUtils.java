package com.util;

public class ArrayUtils {

	public static int[] array = { 8, 3, 5, 0, 9, 1, 6, 4, 2 };

	public static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0, l = array.length; i < l; i++) {
			System.out.print(array[i]);
			if (i < l - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 4, 5 };
		printArray(array);
	}

}
