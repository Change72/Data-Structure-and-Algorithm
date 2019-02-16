package solution;

public class Problem_080 {
	class Solution {
	    public int removeDuplicates(int[] nums) {    	
	    	int ans = 1;
	    	for(int i = 1; i < nums.length; i++) {
	    		if(nums[i] == nums[i - 1]) {
					while(i + 1 < nums.length && nums[i + 1] == nums[i])
						i ++;
				}
	    		if(i < nums.length) {
	    			nums[ans] = nums[i];
	    			ans = ans + 1;
	    		}
	    	}
	        return ans;	        
	    }
	}
	    
	public void TestCase() {
		Solution solution = new Solution();

		int[] nums = new int[] { 1, 1 };
		int len = solution.removeDuplicates(nums);
		for (int i = 0; i < len; i++)
			System.out.println(nums[i]);

		System.out.println("---- Second Test Case ----");
		int[] nums2 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int len2 = solution.removeDuplicates(nums2);
		for (int i = 0; i < len2; i++)
			System.out.println(nums2[i]);
	}
}
