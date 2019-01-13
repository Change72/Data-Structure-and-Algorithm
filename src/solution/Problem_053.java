package solution;

public class Problem_053 {
	// Dynamic Programming
	class Solution {
	    public int maxSubArray(int[] nums) {
	    	if(nums.length == 0)
	    		return 0;
	    	int max = Integer.MIN_VALUE;
	    	int currentSeq = 0;
	    	for(int i = 0; i < nums.length; i ++) {
	    		currentSeq = Math.max(currentSeq + nums[i], nums[i]);
	    		max = Math.max(currentSeq, max);
	    	}
	    	return max;
	    }
	}
	
	// Divide and Conquer
	class Solution_2 {
	    public int maxSubArray(int[] nums) {
	    	if(nums.length == 0) 
	    		return 0;
	    	return maxSub(nums, 0, nums.length - 1);
	    }
	    	
	    public int maxSub(int[] nums, int start, int end) {
	    	// boundary
	    	if(start == end)
	    		return nums[start];
	    	
	    	if(start > end)
	    		return Integer.MIN_VALUE;
	    	
	    	// declare
	    	int middle = (start + end) / 2;
	    	
	    	// core
	    	int left_max = maxSub(nums, start, middle);
	    	int right_max = maxSub(nums, middle + 1, end);
	    	
	    	int ml = 0, mr = 0;
	    	for(int i = middle - 1, sum = 0; i >= start; i --) {
	    		sum += nums[i];
	    		ml = ml > sum ? ml : sum;
	    	}
	    	for(int i = middle + 1, sum = 0; i <= end; i ++ ) {
	    		sum += nums[i];
	    		mr = mr > sum ? mr : sum;
	    	}
	    	
	    	return Math.max(Math.max(left_max, right_max), ml + mr + nums[middle]);
	    }
	}
	
	public void TestCase() {
		Solution solution = new Solution();

		System.out.println("---     First Solution    ---");
		int[] nums = new int[] {-2,-5,5,6,-1,-2,3,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-2,-1,-3,-4};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-2};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {2};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-2,1,-3,0,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-2,1};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-1,0,-2};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-2,-1};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {3,0,0,2,2};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-2,3,-3,1,1,-1,1,1,1};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-5,8,-5,1,1,-3,5,5,-3,-3,6,4,-7,-4,-8,0,-1,-6};
		System.out.println(solution.maxSubArray(nums));
		nums = new int[] {-9,-2,1,8,7,-6,4,9,-9,-5,0,5,-2,5,9,7};
		System.out.println(solution.maxSubArray(nums));
		
		Solution solution_2 = new Solution();

		System.out.println("---     Second Solution    ---");
		nums = new int[] {-2,-5,5,6,-1,-2,3,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-2,-1,-3,-4};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-2};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {2};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-2,1,-3,0,-1,2,1,-5,4};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-2,1};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-1,0,-2};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-2,-1};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {3,0,0,2,2};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-2,3,-3,1,1,-1,1,1,1};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-5,8,-5,1,1,-3,5,5,-3,-3,6,4,-7,-4,-8,0,-1,-6};
		System.out.println(solution_2.maxSubArray(nums));
		nums = new int[] {-9,-2,1,8,7,-6,4,9,-9,-5,0,5,-2,5,9,7};
		System.out.println(solution.maxSubArray(nums));
	}
}
