package solution;

import java.util.HashSet;
import java.util.Set;

public class Problem_136 {
//	136
	public static class Solution {
	    public int singleNumber(int[] nums) {
	    	Set<Integer> set = new HashSet<Integer>();
	    	for(int i = 0; i < nums.length; i ++)
	    		if(set.contains(nums[i]))
	    			set.remove(nums[i]);
	    		else
	    			set.add(nums[i]);
	        return set.iterator().next();
	    }
	}
}
