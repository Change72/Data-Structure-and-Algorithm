package dataStructure.heap;

import java.util.Arrays;

/**
 * @author change
 * 最大堆
 * 主要功能 ： 堆排序、优先队列
 * 最大优先队列，无论入队顺序，当前最大的元素优先出队
 * 与 MaxHeap 不同的是，这个类使用 private 记录 堆 和 堆大小
 */
/*
 * Heap sort using linked lists
 * The answer is "you don't want to implement heap sort on a linked list."
 * 
 * Heapsort is a good sorting algorithm because it's O(n log n) and it's in-place. 
 * However, when you have a linked list heapsort is no longer O(n log n) because it relies on random access to the array, 
 * which you do not have in a linked list. So you either lose your in-place attribute (but needing to define a tree-like structure is 
 * O(n) space). Or you will need to do without them, but remember that a linked list is O(n) for member lookup. Which brings the runtime 
 * complexity to something like O(n^2 log n) which is worse than bubblesort.
 * 
 * Just use mergesort instead. You already have the O(n) memory overhead requirement.
 * 
 * 用链表建堆的想法
 * 		
 * 不要用链表建堆，因为堆本身的结构特性 高度依赖于 数组的随机访问（eg.交换操作），而如果直接使用链表，其查找时间为 O(n) -> 从索引i到2i的过程，且指针的修改更为复杂
 * 如果从 数组->链表，则需要额外的空间 O(n)(which means define a tree-like structure needs O(n) space)
 */
public class MaxHeapModel {
	/**
	 * 堆 参数
	 */
	private int[] nums;
	private int heapSize;
	
	/**
	 * 堆 构造函数
	 */
	public MaxHeapModel() {
		this.nums = new int[32];
	}
	
	public MaxHeapModel(int[] nums) {
		this.nums = nums;
		this.heapSize = nums.length;
	}
	
	/**
	 * 堆 getter and setter
	 */
	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

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
	
	public void swap(int i, int j) {
		int temp = this.nums[j];
		this.nums[j] = this.nums[i];
		this.nums[i] = temp;
	}
	
	/**
	 * 堆 扩容
	 * Arrays.copyOf() 用于复制指定的数组内容以达到扩容的目的
	 */
	public void resize() {
		int newSize = this.heapSize * 2;
		this.nums = Arrays.copyOf(this.nums, newSize);
	}
	
	/**
	 *	最大堆的堆调整，时间复杂度 O(logn)
	 *	元素自顶下沉的过程，堆大小是一个重要参数
	 */
	public void maxHeapify(int i) {
		int l = this.left(i);
		int r = this.right(i);
		int largest = i;
		if(l < this.heapSize && this.nums[l] > this.nums[i])
			largest = l;
		if(r < this.heapSize && this.nums[r] > this.nums[largest])
			largest = r;
		if(largest != i) {
			this.swap(i, largest);
			// recursion
			this.maxHeapify(largest);
		}	
	}
	
	/**
	 *	建最大堆 O(n)
	 */
	public void maxBuildHeap() {
		for(int i = (this.heapSize - 1) / 2; i >= 0; i --)
			this.maxHeapify(i);
	}
	
	/**
	 *	最大堆 堆排序 O(nlogn)
	 */
	public int[] maxHeapSort() {
		maxBuildHeap();
		while(this.heapSize > 1) {
			this.heapSize --;
			this.swap(this.heapSize, 0);
			this.maxHeapify(0);
		}
		return this.nums;
	}
	
	/**
	 *	最大堆 元素上浮，先建堆
	 *	时间复杂度 O(logn)
	 */
	public void maxUpHeapify(int i) {
		if(i == 0)
			return;
		int p = this.parent(i);
		if(this.nums[p] < this.nums[i]) {
			this.swap(i, p);
			this.maxUpHeapify(p);
		}
	}
	
	/**
	 *	最大堆 插入元素
	 *	复制数组到新的数组中，实现堆大小的扩大 O(n)，然后新增元素上浮 O(logn)
	 */
	public void maxInsert(int value) {
		if(this.heapSize == this.nums.length)
			this.resize();
		this.nums[this.heapSize] = value;
		this.maxUpHeapify(this.heapSize);
		this.heapSize ++;
	}
	
	/**
	 *	最大堆 删除元素，按索引删除
	 */
	public void maxDelete(int i) {
		if(i < 0 || i >= this.heapSize)
			return;
		this.heapSize --;
		this.swap(i, this.heapSize);
		this.maxHeapify(i);
	}
	
	/**
	 *	最大堆 获取最大元素
	 */
	public int maxMaximum() {
		return this.nums[0];
	}
	
	/**
	 *	最大堆 去掉并返回S中具有的最大元素
	 */
	public int extractMaxHeap() {
		int max = maxMaximum();
		this.maxDelete(0);;
		return max;
	}
	
	/**
	 *	最大堆 将S中 索引 为 i 的元素 的 值 增大到 value
	 */
	public String maxIncreaseKey(int i, int value) {
		if(value < this.nums[i])
			return "new value is smaller than current value";
		this.nums[i] = value;
		this.maxUpHeapify(i);
		return "Success";
	}
	
	
	/**
	 *	最大堆 优先队列应用场景 —— 共享计算机系统的作业调度
	 *	调用思路：
	 *		1、堆中记录的是 将要执行的各个作业 及 相对优先级
	 *		2、【出队】当一个作业 完成或中断 后，调用 extractMaxHeap 从所有等待作业中，选出优先级最高的来执行
	 *		3、【入队】调用 maxInsert 新增任务
	 */
	
	
	public void TestCase() {
		int[] nums = new int[] {1, -5, 4, 9, 2, 7, 11, 15};
		MaxHeapModel maxHeapModel = new MaxHeapModel(nums);
		System.out.println(Arrays.toString(maxHeapModel.maxHeapSort()));
		maxHeapModel.setHeapSize(maxHeapModel.getNums().length);
		maxHeapModel.maxBuildHeap();
		System.out.println(Arrays.toString(maxHeapModel.getNums()));
		maxHeapModel.maxInsert(20);
		System.out.println(Arrays.toString(maxHeapModel.getNums()));
		maxHeapModel.maxDelete(1);
		System.out.println(Arrays.toString(maxHeapModel.getNums()));
		System.out.println(maxHeapModel.getHeapSize());
		System.out.println(maxHeapModel.maxMaximum());
		System.out.println(maxHeapModel.extractMaxHeap());
		System.out.println(Arrays.toString(maxHeapModel.getNums()));
		System.out.println(maxHeapModel.maxIncreaseKey(2, 30));
		System.out.println(Arrays.toString(maxHeapModel.getNums()));
	}
	
}