package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
	// 2路 归并排序，将 原问题 拆解为 2 个 子问题
	public int[] mergeSort(int[] nums, int begin, int end) {
		if(begin == end)
			return nums;
		int middle = (int) Math.floor((double)(begin + end + 1) / 2);
		mergeSort(nums, begin, middle - 1);
		mergeSort(nums, middle, end);
		merge(nums, begin, middle, end);
		return nums;
	}
	
	public void merge(int[]nums, int begin, int middle, int end) {
		int[] ans = new int[end - begin + 1];
		int i = begin;
		int j = middle;
		for(int k = 0; k <= end - begin; k ++) {
			if(i < middle && j <= end) {
				if(nums[i] <= nums[j]) {
					ans[k] = nums[i];
					i ++;
				}else {
					ans[k] = nums[j];
					j ++;
				}
				continue;
			}
			while(i < middle) {
				ans[k] = nums[i];
				i ++;
				k ++;
			}
			while(j <= end) {
				ans[k] = nums[j];
				j ++;
				k ++;
			}
		}
		// copy to origin array
		i = begin;
		for(int k = 0; k <= end - begin; k ++) {
			nums[i] = ans[k];
			i ++;
		}
	}
	

	
	public void TestCase() {
		int[] nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length - 1)));
	}
}
