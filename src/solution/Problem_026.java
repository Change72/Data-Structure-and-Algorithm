package solution;

public class Problem_026 {
	
	class Solution {
		public int removeDuplicates(int[] nums) {
			if (nums.length == 0)
				return 0;
			int ans = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[ans] != nums[i]) {
					ans = ans + 1;
					nums[ans] = nums[i];
				}
			}
			return ans + 1;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		
		int[] nums = new int[] {1,1,2};
		int len = solution.removeDuplicates(nums);
		for(int i = 0; i < len; i++) 
			System.out.println(nums[i]);
		
		System.out.println("---- Second Test Case ----");
		int[] nums2 = new int[] {0,0,1,1,1,2,2,3,3,4};
		int len2 = solution.removeDuplicates(nums2);
		for(int i = 0; i < len2; i++) 
			System.out.println(nums2[i]);
	}
}
