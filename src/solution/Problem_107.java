package solution;

import java.util.ArrayList;
import java.util.List;


public class Problem_107 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
//	107
	public static class Solution {
		private List<List<Integer>> dynamicMatrix;
		private int height;
		
		public Solution() {
			this.dynamicMatrix = new ArrayList<List<Integer>>();
			this.height = 0;
		}

		public void buildDynamicMatrix(TreeNode p, int depth) {
			if(p == null)
				return;
			dynamicMatrix.get(height - depth - 1).add(p.val);
	        buildDynamicMatrix(p.left, depth + 1);
	        buildDynamicMatrix(p.right, depth + 1);
		}
		
		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
		
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    	height = maxDepth(root); 
	    	for(int i = 0; i < height; i ++)
	    		dynamicMatrix.add(new ArrayList<Integer>());
	    	buildDynamicMatrix(root, 0);
	        return dynamicMatrix;
	    }
	}
}
