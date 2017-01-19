package com.mine.sort;

public class SortDemo {

	public static void main(String[] args) {
		int[] array = null;

//		array = new int[] { 9, 1, 5, 7, 2 };
//		bubble(array);
//
//		array = new int[] { 9, 1, 5, 7, 2 };
//		insert(array);

		array = new int[] { 9, 1, 5, 7, 2 };
		quick(array);

	}
	
	private static void print(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	private static void quick(int[] array) {
		System.out.println("quick");
		print(array);
		quick(array, 0, array.length - 1);
		print(array);
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
		int temp = arr[left]; // 中轴
		while (left < right) {
			// 比中轴小的移到低端
			while (left < right && arr[right] > temp) {
				right--;
			}
			arr[left] = arr[right];

			// 比中轴大的移到高端
			while (left < right && arr[left] < temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp; // 中轴记录到尾
		return left;
	}

	private static void insert(int[] array) {
		System.out.println("insert");
		print(array);

		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				} else {
					break;
				}
			}
		}

		print(array);
	}

	private static void bubble(int[] array) {
		System.out.println("bubble");
		print(array);

		int temp = 0;
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j + 1] < array[j]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		print(array);
	}

}
