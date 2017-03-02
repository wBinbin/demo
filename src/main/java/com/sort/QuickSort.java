package com.sort;

import com.util.ArrayUtils;

/**
 * 快速排序
 * 
 * @Author Patrick 魏彬彬
 * @Date 2016年9月2日
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = ArrayUtils.array;
		ArrayUtils.printArray(array);

//		quick(array, 0, array.length - 1);
		
		quick(array, 0, array.length - 1);
		
		ArrayUtils.printArray(array);
	}

//	private static void quick(int[] a, int left, int right) {
//		int middle = 0;
//		if (left < right) {
//			middle = middle(a, left, right);
//			quick(a, left, middle - 1);
//			quick(a, middle + 1, right);
//		}
//	}
//
//	private static int middle(int[] a, int left, int right) {
//		int temp = a[left];
//		while (left < right) {
//			while (left < right && a[right] >= temp) {
//				right--;
//			}
//			a[left] = a[right];
//
//			while (left < right && a[left] <= temp) {
//				left++;
//			}
//			a[right] = a[left];
//		}
//		a[left] = temp;
//		return left;
//	}
	
	private static void quick(int[] arr, int left, int right) {
		int middle = 0;
		if (left < right) {
			middle = middle(arr, left, right);
			quick(arr, left, middle - 1);
			quick(arr, middle + 1, right);
		}
	}

	private static int middle(int[] arr, int left, int right) {
		int temp = arr[left];
		while (left < right) {
			if (left < right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right];
			
			if (left < right && arr[left] <= temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}

}
