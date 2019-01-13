package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	// 冒泡排序经典版
	public int[] bubbleSort(int[] nums) {
		int k = 0;
		for(int i = 0; i < nums.length; i ++) 
			for(int j = 0; j < nums.length - i - 1; j ++) {
				k ++;
				if(nums[j] > nums[j + 1]) 
					swap(nums, j, j + 1);
			}
		System.out.println(k);
		return nums;
	}
	
	// 冒泡排序 —— 每次是相邻的元素相比较，否则不是经典冒泡，如下
	public int[] bubbleSort_False(int[] nums) {
		for(int i = 0; i < nums.length; i ++) 
			for(int j = i + 1; j < nums.length; j ++) 
				if(nums[j] < nums[i])
					swap(nums, i, j);
		return nums;
	}
	
	// 初级改良版 —— 增加是否有交换的标识，如果没有交换证明已全部排好序，则可直接返回
	public int[] bubbleSort2(int[] nums) {
		int k = 0;
		for(int i = 0; i < nums.length; i ++) {
			boolean isSwap = false;
			for(int j = 0; j < nums.length - i - 1; j ++) {
				k ++;
				if(nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
					isSwap = true;
				}
			}

			if(!isSwap) {
				System.out.println(k);
				return nums;
			}
		}
		return nums;
	}
	
	// 高级改良版 —— 增加最后一次交换的位置，在一个序列后半部分有序时，直接跳过后半部分
	public int[] bubbleSort3(int[] nums) {
		int k = 0;
		int location = nums.length;
		for(int i = 0; i < nums.length; i ++) {
			boolean isSwap = false;
			int temp = 0;
			for(int j = 0; j < location - 1; j ++) {
				k++;
				if(nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
					isSwap = true;
					temp = j;
				}
			}
			location = temp;
			if(!isSwap) {
				System.out.println(k);
				return nums;
			}
		}
		return nums;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public void TestCase() {
		int[] nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(bubbleSort(nums)));
		nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(bubbleSort2(nums)));
		nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(bubbleSort3(nums)));
	}
}
