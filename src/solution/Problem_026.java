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
	// faster
	class Solution_2 {
		public int removeDuplicates(int[] nums) {
			int ans = 1;
			for (int i = 1; i < nums.length; i++) {
				while (i < nums.length && nums[i] == nums[i - 1])
					i++;
				if (i < nums.length) {
					nums[ans] = nums[i];
					ans = ans + 1;
				}
			}
			return ans;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		
		System.out.println("---- First Solution ----");
		System.out.println("---- First Test Case ----");
		int[] nums = new int[] {1,1,2};
		int len = solution.removeDuplicates(nums);
		for(int i = 0; i < len; i++) 
			System.out.println(nums[i]);
		
		System.out.println("---- Second Test Case ----");
		int[] nums2 = new int[] {0,0,1,1,1,2,2,3,3,4};
		int len2 = solution.removeDuplicates(nums2);
		for(int i = 0; i < len2; i++) 
			System.out.println(nums2[i]);
		
		System.out.println("---- Third Test Case ----");
		int[] nums3 = new int[] {0,0,1,1};
		int len3 = solution.removeDuplicates(nums3);
		for(int i = 0; i < len3; i++) 
			System.out.println(nums3[i]);
		

		System.out.println("---- Second Solution ----");
		Solution_2 solution2 = new Solution_2();
		System.out.println("---- First Test Case ----");
		nums = new int[] {1,1,2};
		len = solution2.removeDuplicates(nums);
		for(int i = 0; i < len; i++) 
			System.out.println(nums[i]);
		
		System.out.println("---- Second Test Case ----");
		nums2 = new int[] {0,0,1,1,1,2,2,3,3,4};
		len2 = solution2.removeDuplicates(nums2);
		for(int i = 0; i < len2; i++) 
			System.out.println(nums2[i]);
		
		System.out.println("---- Third Test Case ----");
		nums3 = new int[] {0,0,1,1};
		len3 = solution2.removeDuplicates(nums3);
		for(int i = 0; i < len3; i++) 
			System.out.println(nums3[i]);	
	}
}
