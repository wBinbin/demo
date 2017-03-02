package com.sort;

import com.util.ArrayUtils;

/**
 * 冒泡排序
 * 
 * @Author Patrick 魏彬彬
 * @Date 2016年9月2日
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = ArrayUtils.array;
		ArrayUtils.printArray(array);
		bubble(array);
		ArrayUtils.printArray(array);
		
	}

	private static void bubble(int[] array) {
//		int temp = 0;
//		int l = array.length;
//		for (int i = 0; i < l - 1; i++) {
//			for (int j = l - 1; j > i; j--) {
//				if (array[j] > array[j - 1]) {
//					temp = array[j - 1];
//					array[j - 1] = array[j];
//					array[j] = temp;
//				}
//			}
//		}
		
		int temp = 0;
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
	
}
