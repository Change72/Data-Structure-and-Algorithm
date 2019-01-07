package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	public int[] bubbleSort(int[] nums) {
		for(int i = 0; i < nums.length; i ++) 
			for(int j = i + 1; j < nums.length; j ++) 
				if(nums[j] < nums[i])
					swap(nums, i, j);
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
	}
}
