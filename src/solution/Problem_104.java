package solution;

public class Problem_104 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
//	104	
	public static class Solution {
	    public int maxDepth(TreeNode root) {
	        if(root == null)
	        	return 0;
	        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	    }
	}
}
