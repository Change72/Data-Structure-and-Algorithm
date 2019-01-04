package solution;

public class Problem_027 {
	
	class Solution {
		public int removeElement(int[] nums, int val) {
			if (nums.length == 0)
				return 0;
			int ans = 0;
			for (int i = 0; i < nums.length; i++) {
				if (val != nums[i]) {
					nums[ans] = nums[i];
					ans = ans + 1;
				}
			}
			return ans;
		}
	}

	public void TestCase() {
		Solution solution = new Solution();
		
		int[] nums = new int[] {3,2,2,3};
		System.out.println(solution.removeElement(nums, 3));
		
		int[] nums2 = new int[] {0,1,2,2,3,0,4,2};
		System.out.println(solution.removeElement(nums2, 2));
	}
}
