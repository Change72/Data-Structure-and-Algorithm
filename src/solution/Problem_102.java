package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_102 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
//	102
	public static class Solution {
		private List<List<Integer>> dynamicMatrix;
		
		public Solution() {
			this.dynamicMatrix = new ArrayList<List<Integer>>();
		}

		public void buildDynamicMatrix(TreeNode p, int depth) {
			if(p == null)
				return;
			if(dynamicMatrix.size() > depth) 
				dynamicMatrix.get(depth).add(p.val);
			else 
				dynamicMatrix.add(new ArrayList<Integer>(Arrays.asList(p.val)));
	        buildDynamicMatrix(p.left, depth + 1);
	        buildDynamicMatrix(p.right, depth + 1);
		}
		
	    public List<List<Integer>> levelOrder(TreeNode root) {
	    	buildDynamicMatrix(root, 0);
	        return dynamicMatrix;
	    }
	}
}
