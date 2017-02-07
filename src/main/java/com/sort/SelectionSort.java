package com.sort;

import com.util.ArrayUtils;

/**
 * 选择排序
 * 
 * @Author Patrick 魏彬彬
 * @Date 2016年9月2日
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = ArrayUtils.array;
		ArrayUtils.printArray(array);

		selection(array);
		ArrayUtils.printArray(array);
	}

	private static void selection(int[] array) {
		for (int i = 0, l = array.length; i < l; i++) {
			int index = i;
			for (int j = i + 1; j < l; j++) {
				if (array[index] > array[j]) {
					index = j;
				}
			}

			int temp = array[index];
			;
			array[index] = array[i];
			array[i] = temp;
		}
	}

}
