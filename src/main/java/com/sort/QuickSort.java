package com.sort;


public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 8, 3, 5, 0, 9, 1, 6, 4, 2 };
		SortUtil.printArray(array);

		quick(array, 0, array.length - 1);
		SortUtil.printArray(array);
	}

	private static void quick(int[] array, int left, int right) {
		int middle = 0;
		if (left < right) {
			middle = middle(array, left, right);
			quick(array, left, middle - 1);
			quick(array, middle + 1, right);
		}
	}

	private static int middle(int[] array, int left, int right) {
		int temp = array[left];

		while (left < right) {
			while (left < right && array[right] <= temp) {
				right--;
			}
			array[left] = array[right];

			while (left < right && array[left] >= temp) {
				left++;
			}
			array[right] = array[left];
		}
		array[left] = temp;
		
		return left;
	}

}
