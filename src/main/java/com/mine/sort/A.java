package com.mine.sort;

import com.alibaba.fastjson.JSON;

public class A {

	public static void main(String[] args) {
		int[] arr = null;
		
		// bubble
		arr = new int[] { 9, 8, 7, 6, 5, 4 };
		int temp = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(JSON.toJSONString(arr));
		
		// insert
		arr = new int[] { 6, 8, 7, 3, 5, 4 };
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] > arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					break;
				}
			}
		}
		System.out.println(JSON.toJSONString(arr));
		
		// quick
		arr = new int[] { 6, 8, 7, 3, 5, 4 };
		quick(arr, 0, arr.length - 1);
		System.out.println(JSON.toJSONString(arr));
	}

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
			while (left < right && arr[right] > temp) {
				right--;
			}
			arr[left] = arr[right];
			
			while (left < right && arr[left] < temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}

}
