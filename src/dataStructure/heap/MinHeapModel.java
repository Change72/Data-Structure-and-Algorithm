package dataStructure.heap;

import java.util.Arrays;

/**
 * @author change
 * 最小堆
 * 主要功能 ： 堆排序、优先队列
 * 最小优先队列，无论入队顺序，当前最小的元素优先出队
 * 与 MinHeap 不同的是，这个类使用 private 记录 堆 和 堆大小
 */
public class MinHeapModel {
	/**
	 * 堆 参数
	 */
	private int[] nums;
	private int heapSize;
	
	/**
	 * 堆 构造函数
	 */
	public MinHeapModel() {
		this.nums = new int[32];
	}
	
	public MinHeapModel(int[] nums) {
		this.nums = nums;
		heapSize = nums.length;
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
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
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
	 *	最小堆 的堆调整，时间复杂度 O(logn)，层数即为路径长度
	 *	元素依次下沉的过程
	 */
	public void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if(l < this.heapSize && this.nums[l] < this.nums[i])
			smallest = l;
		if(r < this.heapSize && this.nums[r] < this.nums[smallest])
			smallest = r;
		if(smallest != i) {
			swap(i, smallest);
			// recursion
			this.minHeapify(smallest);
		}	
	}
	
	/**
	 *	建最小堆 O(n)
	 */
	public void minBuildHeap() {
		for(int i = (this.heapSize - 1) / 2; i >= 0; i --)
			this.minHeapify(i);
	}
	
	/**
	 *	最小堆 堆排序 O(nlogn)
	 *	空间复杂度 O(n)，因为正常出堆是逆序的
	 */
	public int[] minHeapSort() {
		this.minBuildHeap();
		int numsLength = this.heapSize;
		int[] ans = new int[this.heapSize];
		while(this.heapSize > 1) {
			
			this.heapSize --;
			this.swap(this.heapSize, 0);
			ans[numsLength - this.heapSize - 1] = this.nums[this.heapSize];
			this.minHeapify(0);
			
		}
		ans[numsLength - 1] = this.nums[0];
		// a 为 逆序排列，即 从大到小
		// return a;
		return ans;
		
	}
	
	/**
	 *	最小堆 元素上浮，先建堆
	 *	时间复杂度 O(logn)
	 */
	public void minUpHeapify(int i) {
		if(i == 0)
			return;
		int p = this.parent(i);
		if(this.nums[p] > this.nums[i]) {
			swap(i, p);
			minUpHeapify(p);
		}
	}
	
	/**
	 *	最小堆 插入元素
	 *	复制数组到新的数组中，实现堆大小的扩大 O(n)，然后新增元素上浮 O(logn)
	 */
	public void minInsert(int value) {
		if(this.heapSize == this.nums.length)
			this.resize();
		this.nums[this.heapSize] = value;
		minUpHeapify(this.heapSize);
		this.heapSize ++;
	}
	
	/**
	 *	最小堆 删除元素，按索引删除
	 */
	public void minDelete(int i) {
		if(i < 0 || i >= this.heapSize)
			return;
		this.heapSize --;
		this.swap(i, this.heapSize);
		this.minHeapify(i);
	}
	
	/**
	 *	最小堆 获取最小元素
	 */
	public int minMinimum() {
		return this.nums[0];
	}
	
	/**
	 *	最小堆 去掉并返回S中具有的最小元素
	 */
	public int extractMinHeap() {
		int min = this.minMinimum();
		this.minDelete(0);
		return min;
	}
	
	/**
	 *	最小堆 将S中 索引 为 i 的元素 的 值 减小到 value
	 */
	public String minDecreaseKey(int i, int value) {
		if(value > this.nums[i])
			return "new value is greater than current value";
		this.nums[i] = value;
		this.minUpHeapify(i);
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
		MinHeapModel minHeapModel = new MinHeapModel(nums);
		System.out.println(Arrays.toString(minHeapModel.minHeapSort()));
		minHeapModel.setHeapSize(minHeapModel.getNums().length);
		minHeapModel.minBuildHeap();
		System.out.println(Arrays.toString(minHeapModel.getNums()));
		
		minHeapModel.minInsert(3);
		System.out.println(Arrays.toString(minHeapModel.getNums()));
		minHeapModel.minDelete(1);
		System.out.println(Arrays.toString(minHeapModel.getNums()));
		System.out.println(minHeapModel.minMinimum());
		System.out.println(minHeapModel.extractMinHeap());
		System.out.println(Arrays.toString(minHeapModel.getNums()));
		System.out.println(minHeapModel.minDecreaseKey(2, -4));
		System.out.println(Arrays.toString(minHeapModel.getNums()));
		
		nums = new int[] {7,1,3,10,5,2,8,9,6};
		minHeapModel.setNums(nums);
		minHeapModel.setHeapSize(nums.length);
		minHeapModel.minBuildHeap();
		System.out.println(Arrays.toString(minHeapModel.getNums()));
		System.out.println(Arrays.toString(minHeapModel.minHeapSort()));
		minHeapModel.setHeapSize(minHeapModel.getNums().length);
	}
}
