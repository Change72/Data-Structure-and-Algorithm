package algorithm.sort;

import java.util.Arrays;

public class InsertSort {
	
	// 时间复杂度 最坏 + 平均 O(n^2), 最好 O(n)（本就有序时）, 空间复杂度 O(1)
	public int[] insertSort(int[] nums) {
		for(int i = 1; i < nums.length; i ++) {
			int j = 0;
			int temp = nums[i];
			for(j = i - 1; j >= 0; j--) {
				if(temp < nums[j]) 
					nums[j + 1] = nums[j];
				else
					break;
			}
			nums[j + 1] = temp;
		}
		return nums;
	}
	
//  使用新数组，空间复杂度为 O(n)
//	public int[] insertSort(int[] nums) {
//		int[] ans = new int[nums.length];
//		ans[0] = nums[0];
//		for(int i = 1; i < nums.length; i ++) {
//			int j = 0;
//			for(j = i - 1; j >= 0; j--) {
//				if(nums[i] < ans[j]) 
//					ans[j + 1] = ans[j];
//				else
//					break;
//			}
//			ans[j + 1] = nums[i];
//		}
//		return ans;
//	}
	
	public void TestCase() {
		int[] nums = new int[] {0, -5, 4, 9, 2, 7, 11, 15};
		System.out.println(Arrays.toString(insertSort(nums)));
	}
}
