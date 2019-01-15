package algorithm.sort;

import java.util.Arrays;

/**
 * @author change
 * 堆排序
 * 算法导论中的 下标 从 1 开始，而 Java 数组从 0 开始，需要做出调整
 */
public class HeapSort {
	/**
	 * 堆 基础函数
	 *
	 */
	public int parent(int i) {
		return (i + 1) / 2 - 1;
	}
	
	public int left(int i) {
		return 2 * i + 1;
	}
	
	public int right(int i) {
		return 2 * i + 2;
	}
	
	public int[] swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
		return nums;
	}
	
	/**
	 *	最大堆的堆调整，时间复杂度 O(logn)
	 *	元素自顶下沉的过程，堆大小是一个重要参数
	 */
	public void maxHeapify(int[] a, int heapSize, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if(l < heapSize && a[l] > a[i])
			largest = l;
		if(r < heapSize && a[r] > a[largest])
			largest = r;
		if(largest != i) {
			swap(a, i, largest);
			// recursion
			maxHeapify(a, heapSize, largest);
		}	
	}
	
	/**
	 *	建最大堆 O(n)
	 */
	public void buildMaxHeap(int[] a) {
		for(int i = (a.length - 1) / 2; i >= 0; i --)
			maxHeapify(a, a.length, i);
	}
	
	/**
	 *	最大堆 堆排序 O(nlogn)
	 */
	public int[] heapMaxSort(int[] a) {
		buildMaxHeap(a);
		for(int i = a.length - 1; i > 0; i --) {
			swap(a, i, 0);
			maxHeapify(a, i, 0);
		}
		return a;
	}
	
	public void TestCase() {
		int[] nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(heapMaxSort(nums)));
	}
}
