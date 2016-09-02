package com.sort;

public class HeapSort extends SortUtils {

	public static void main(String[] args) {
		int[] array = { 8, 3, 5, 0, 9, 1, 6, 4, 2 };
		SortUtils.printArray(array);

		heap(array);
		SortUtils.printArray(array);
	}

	private static void heap(int[] array) {
		// 构建最大堆
		buildMaxHeap(array);
		// 循环，每次把根节点和最后一个节点调换位置
		for (int i = array.length; i > 1; i--) {
			int temp = array[0];
			array[0] = array[i - 1];
			array[i - 1] = temp;

			// 堆的长度减少1，排除置换到最后位置的根节点
			maxHeapify(array, 1, i - 1);
		}
	}

	/**
	 * 构建最大堆
	 * 
	 * @param array
	 */
	private static void buildMaxHeap(int[] array) {
		for (int i = array.length / 2; i > 0; i--) {
			// 堆调整
			maxHeapify(array, i, array.length);
		}
	}

	/**
	 * 堆调整
	 * 
	 * @param array
	 * @param i
	 * @param length
	 */
	private static void maxHeapify(int[] array, int parentNodeIndex, int heapSize) {
		// 左子节点索引
		int leftChildNodeIndex = parentNodeIndex * 2;
		// 右子节点索引
		int rightChildNodeIndex = parentNodeIndex * 2 + 1;
		// 最大节点索引
		int largestNodeIndex = parentNodeIndex;

		// 如果左子节点大于父节点，则将左子节点作为最大节点
		if (leftChildNodeIndex <= heapSize && array[leftChildNodeIndex - 1] > array[parentNodeIndex - 1]) {
			largestNodeIndex = leftChildNodeIndex;
		}

		// 如果右子节点比最大节点还大，那么最大节点应该是右子节点
		if (rightChildNodeIndex <= heapSize && array[rightChildNodeIndex - 1] > array[largestNodeIndex - 1]) {
			largestNodeIndex = rightChildNodeIndex;
		}

		// 最后，如果最大节点和父节点不一致，则交换他们的值
		if (largestNodeIndex != parentNodeIndex) {
			int temp = array[parentNodeIndex - 1];
			array[parentNodeIndex - 1] = array[largestNodeIndex - 1];
			array[largestNodeIndex - 1] = temp;
			maxHeapify(array, largestNodeIndex, heapSize);
		}
	}

}
