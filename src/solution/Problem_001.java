package solution;

import java.util.HashMap;
import java.util.Map;

public class Problem_001 {
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			for (int i = nums.length - 1; i >= 0; i--) {
				for (int j = nums.length - 1; j >= 0; j--) {
					if (i == j)
						continue;
					if (nums[i] + nums[j] == target) {
						int[] result = new int[2];
						result[0] = j;
						result[1] = i;
						return result;
					}
				}
			}
			return null;
		}
	}

	class Solution_2 {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(target - nums[i]))
					return new int[] { map.get(target - nums[i]), i };
				map.put(nums[i], i);
			}
			return null;
		}
	}

	class Solution_3 {
		public int[] twoSum(int[] nums, int target) {
			int[] orderedArray = quickSort(nums, 0, nums.length - 1);
			for (int i = nums.length - 1; i >= 0; i--) {
				if (orderedArray[i] > target)
					continue;
				for (int j = i; j >= 0; j--) {
					if (orderedArray[i] + orderedArray[j] == target) {
						int[] result = new int[2];
						for (int k = 0; k < nums.length - 1; k++) {
							if (nums[k] == orderedArray[i])
								result[1] = k;
							if (nums[k] == orderedArray[j])
								result[0] = k;
						}
						return result;
					}
				}
			}
			return null;
		}

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
	}

	public void TestCase() {
		Solution solution = new Solution();
		Solution_2 solution_2 = new Solution_2();
		Solution_3 solution_3 = new Solution_3();
		
		int[] nums = new int[] {2, 7, 11, 15};
		int[] ans = new int[2];
		
		System.out.println("---     First Solution    ---");
		System.out.println("--     使用 数组 暴力枚举           --");
		ans = solution.twoSum(nums, 9);
		System.out.println("[" + ans[0] + "," + ans[1] + "]");
		
		System.out.println("---    Second Solution    ---");
		System.out.println("--  使用 HashMap 效果相较较好  --");
		ans = solution_2.twoSum(nums, 9);
		System.out.println("[" + ans[0] + "," + ans[1] + "]");
		
		System.out.println("---     Third Solution    ---");
		System.out.println("--       先快排 折半枚举           --");
		ans = solution_3.twoSum(nums, 9);
		System.out.println("[" + ans[0] + "," + ans[1] + "]");
	}
}
