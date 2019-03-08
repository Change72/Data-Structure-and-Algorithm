package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author change
 *
 */

public class CountingSort {
	/*
	 * 计数排序是稳定的，对于具有相同值得元素，在输出数组中的次序与输入的相同。
	 * 		也就是说，对两个相同的数，输入数组先出现的，输出数组也先出现
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 * 计数排序不适用的情况：
	 * 	1. 最大最小差值过大
	 *  2. 稀疏数组
	 *  3. 小数情况
	 */
	public int[] countingSort(int[] nums, int maximum) {
		if(nums.length == 0)
			return null;
		if(nums.length == 1)
			return nums;
		int[] ans = new int[nums.length];
		int[] record = new int[maximum];
		// set record: O(n)
		for(int i = 0; i < nums.length; i++)
			record[nums[i]] += 1;
		// arrange record: O(k)
		for(int i = 0; i < maximum - 1; i++)
			record[i + 1] += record[i];
		// set ans: O(n)
		for(int i = nums.length - 1; i >= 0; i--) {
			ans[record[nums[i]] - 1] = nums[i];
			record[nums[i]] -= 1;
		}
		
		
		/*
		 * 此种写法破坏了稳定性

		for(int i = 0; i < nums.length; i++) {
			ans[record[nums[i]] - 1] = nums[i];
			record[nums[i]] -= 1;
		}
		 * 
		 */
		return ans;
	}
	
	/*
	 * 改进版本：最大最小值划定区间范围
	 */
	public int[] improvedCountingSort(int[] nums, int minimum, int maximum) {
		if(nums.length == 0)
			return null;
		if(nums.length == 1)
			return nums;
		int[] ans = new int[nums.length];
		int recordLength = maximum - minimum;
		int[] record = new int[recordLength];
		// set record: O(n)
		for(int i = 0; i < nums.length; i++)
			record[nums[i] - minimum] += 1;
		// arrange record: O(k)
		for(int i = 0; i < recordLength - 1; i++)
			record[i + 1] += record[i];
		// set ans: O(n)
		for(int i = nums.length - 1; i >= 0; i--) {
			ans[record[nums[i] - minimum] - 1] = nums[i];
			record[nums[i] - minimum] -= 1;
		}
		return ans;
	}
	
	public void TestCase() {
		Random random = new Random();
		int[] testArray = new int[10];
		for(int i = 0; i < 10; i++)
			testArray[i] = random.nextInt(20) + 10;
		System.out.println(Arrays.toString(countingSort(testArray, 30)));
		System.out.println(Arrays.toString(improvedCountingSort(testArray, 10, 30)));
		return;
	}

}
