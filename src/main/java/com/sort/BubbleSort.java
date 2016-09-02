package com.sort;

/**
 * 
 * 
 * @Author Patrick 魏彬彬
 * @Date 2016年9月2日
 *
 */
public class BubbleSort extends SortUtil {

	public static void main(String[] args) {
		int[] array = { 8, 3, 5, 0, 9, 1, 6, 4, 2 };
		SortUtil.printArray(array);

		bubble(array);
		SortUtil.printArray(array);
	}

	private static void bubble(int[] array) {
		int temp = 0;
		int l = array.length;
		for (int i = 0; i < l - 1; i++) {
			for (int j = l - 1; j > i; j--) {
				if (array[j] > array[j - 1]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

}
