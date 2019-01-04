package solution;

public class Problem_035 {

	class Solution {
		public int searchInsert(int[] nums, int target) {
			for (int i = 0; i < nums.length; i++) {
				if (target <= nums[i])
					return i;
			}
			return nums.length;
		}
	}

	public void TestCase() {
		Solution solution = new Solution();
		
		int[] nums = new int[] {1,3,5,6};
		System.out.println(solution.searchInsert(nums, 5));
		System.out.println(solution.searchInsert(nums, 2));
		System.out.println(solution.searchInsert(nums, 7));
		System.out.println(solution.searchInsert(nums, 0));
	}

}
