package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	
	public int[] quickSort(int[] nums, int start, int end) {
		if (start + 1 > end)
			return nums;
		int i = start + 1, j = end;
		int target = nums[start];
		while (i != j) {
			while (nums[j] >= target && i < j) {
				j--;
			}
			while (nums[i] <= target && i < j) {
				i++;
			}
			nums = swap(nums, i, j);
		}
		if (nums[i] < target) {
			// swap target to the right place
			nums = swap(nums, start, i);
		}
		if (i > start + 1) {
			nums = quickSort(nums, start, i);
		}
		if (j < end) {
			nums = quickSort(nums, i, end);
		}

		return nums;
	}

	public int[] swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
		return nums;
	}
	
	public void TestCase() {
		int[] nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(quickSort(nums, 0, nums.length - 1)));
	}
}
