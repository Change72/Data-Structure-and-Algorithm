package dataStructure.heap;

import java.util.Arrays;

/**
 * @author change
 * 最大堆 —— 基于函数
 * 主要功能 ： 堆排序、优先队列
 * 最大优先队列，无论入队顺序，当前最大的元素优先出队
 */
public class MaxHeap {
	
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
	
	/**
	 *	最大堆 元素上浮，先建堆
	 *	时间复杂度 O(logn)
	 */
	public void maxUpHeapify(int[] a, int i) {
		if(i == 0)
			return;
		int p = parent(i);
		if(a[p] < a[i]) {
			swap(a, i, p);
			maxUpHeapify(a, p);
		}
	}
	
	/**
	 *	最大堆 插入元素
	 *	复制数组到新的数组中，实现堆大小的扩大 O(n)，然后新增元素上浮 O(logn)
	 */
	public int[] insertElementToMaxHeap(int[] a, int value) {
		int[] ans = new int[a.length + 1];
		System.arraycopy(a, 0, ans, 0, a.length);
		ans[a.length] = value;
		maxUpHeapify(ans, a.length);
		return ans;
	}
	
	/**
	 *	最大堆 删除元素，按索引删除
	 */
	public int[] deleteElementFromMaxHeap(int[] a, int i) {
		if(i < 0 || i >= a.length)
			return null;
		swap(a, i, a.length - 1);
		maxHeapify(a, a.length - 1, i);
		return Arrays.copyOf(a, a.length - 1);
	}
	
	/**
	 *	最大堆 获取最大元素
	 */
	public int maxMaximum(int[] a) {
		return a[0];
	}
	
	/**
	 *	最大堆 去掉并返回S中具有的最大元素
	 */
	public int extractMaxHeap(int[] a) {
		int max = a[0];
		a = deleteElementFromMaxHeap(a, 0);
		return max;
	}
	
	/**
	 *	最大堆 将S中 索引 为 i 的元素 的 值 增大到 value
	 */
	public String maxIncreaseKey(int[] a, int i, int value) {
		if(value < a[i])
			return "new value is smaller than current value";
		a[i] = value;
		maxUpHeapify(a, i);
		return "Success";
	}
	
	
	/**
	 *	最大堆 优先队列应用场景 —— 共享计算机系统的作业调度
	 *	调用思路：
	 *		1、堆中记录的是 将要执行的各个作业 及 相对优先级
	 *		2、当一个作业 完成或中断 后，调用 extractMaxHeap 从所有等待作业中，选出优先级最高的来执行
	 *		3、调用 insertElementToMaxHeap 新增任务
	 */
	
	
	public void TestCase() {
		int[] nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(heapMaxSort(nums)));
		nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		buildMaxHeap(nums);
		System.out.println(Arrays.toString(insertElementToMaxHeap(nums, 20)));
		buildMaxHeap(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(deleteElementFromMaxHeap(nums, 1)));
		System.out.println(maxMaximum(nums));
		System.out.println(extractMaxHeap(nums));
		System.out.println(Arrays.toString(nums));
		System.out.println(maxIncreaseKey(nums, 2, 30));
		System.out.println(Arrays.toString(nums));
	}
}
