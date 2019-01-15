package dataStructure.heap;

import java.util.Arrays;

/**
 * @author change
 * 最小堆 —— 基于函数
 * 主要功能 ： 堆排序、优先队列
 * 最小优先队列，无论入队顺序，当前最小的元素优先出队
 */
public class MinHeap {
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
	 *	最小堆 的堆调整，时间复杂度 O(logn)，层数即为路径长度
	 *	元素依次下沉的过程
	 */
	public void minHeapify(int[] a, int heapSize, int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if(l < heapSize && a[l] < a[i])
			smallest = l;
		if(r < heapSize && a[r] < a[smallest])
			smallest = r;
		if(smallest != i) {
			swap(a, i, smallest);
			// recursion
			minHeapify(a, heapSize, smallest);
		}	
	}
	
	/**
	 *	建最小堆 O(n)
	 */
	public void buildMinHeap(int[] a) {
		for(int i = (a.length - 1) / 2; i >= 0; i --)
			minHeapify(a, a.length, i);
	}
	
	/**
	 *	最小堆 堆排序 O(nlogn)
	 */
	public int[] heapMinSort(int[] a) {
		buildMinHeap(a);
		int[] ans = new int[a.length];
		for(int i = a.length - 1; i > 0; i --) {
			swap(a, i, 0);
			minHeapify(a, i, 0);
			ans[a.length - i - 1] = a[i];
		}
		ans[a.length - 1] = a[0];
		// a 为 逆序排列，即 从大到小
		// return a;
		return ans;
		
	}
	
	/**
	 *	最小堆 元素上浮，先建堆
	 *	时间复杂度 O(logn)
	 */
	public void minUpHeapify(int[] a, int i) {
		if(i == 0)
			return;
		int p = parent(i);
		if(a[p] > a[i]) {
			swap(a, i, p);
			minUpHeapify(a, p);
		}
	}
	
	/**
	 *	最小堆 插入元素
	 *	复制数组到新的数组中，实现堆大小的扩大 O(n)，然后新增元素上浮 O(logn)
	 */
	public int[] insertElementToMinHeap(int[] a, int value) {
		int[] ans = new int[a.length + 1];
		System.arraycopy(a, 0, ans, 0, a.length);
		ans[a.length] = value;
		minUpHeapify(ans, a.length);
		return ans;
	}
	
	/**
	 *	最小堆 删除元素，按索引删除
	 */
	public int[] deleteElementFromMinHeap(int[] a, int i) {
		swap(a, i, a.length - 1);
		minHeapify(a, a.length - 1, i);
		return Arrays.copyOf(a, a.length - 1);
	}
	
	/**
	 *	最小堆 获取最小元素
	 */
	public int minMinimum(int[] a) {
		return a[0];
	}
	
	/**
	 *	最小堆 去掉并返回S中具有的最小元素
	 */
	public int extractMinHeap(int[] a) {
		int min = a[0];
		a = deleteElementFromMinHeap(a, 0);
		return min;
	}
	
	/**
	 *	最小堆 将S中 索引 为 i 的元素 的 值 减小到 value
	 */
	public String minIncreaseKey(int[] a, int i, int value) {
		if(value > a[i])
			return "new value is greater than current value";
		a[i] = value;
		minUpHeapify(a, i);
		return "Success";
	}
	
	
	/**
	 *	最小堆 优先队列应用场景 —— 基于事件驱动的模拟器
	 *	调用思路：
	 *		1、事件必须按照时间顺序进行模拟，因为某一时间的模拟结果可能会触发其他事件的模拟
	 *		2、每一步，调用 extractMinHeap 选出下一个要模拟的事件
	 *		3、调用 insertElementToMinHeap 新增事件
	 */
	
	public void TestCase() {
		int[] nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		buildMinHeap(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(heapMinSort(nums)));
		nums = new int[] {7,1,3,10,5,2,8,9,6};
		buildMinHeap(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(heapMinSort(nums)));
		nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		buildMinHeap(nums);
		System.out.println(Arrays.toString(insertElementToMinHeap(nums, 3)));
		buildMinHeap(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(deleteElementFromMinHeap(nums, 1)));
		System.out.println(minMinimum(nums));
		System.out.println(extractMinHeap(nums));
		System.out.println(Arrays.toString(nums));
		System.out.println(minIncreaseKey(nums, 2, -4));
		System.out.println(Arrays.toString(nums));
	}
}
