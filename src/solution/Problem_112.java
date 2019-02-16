package solution;

public class Problem_112 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
//	112
	public static class Solution {
		public boolean isPathSum(TreeNode root, int sum, int parentValue) {
			if(root == null)
				return false;
			root.val = root.val + parentValue;
			if(root.val == sum && (root.left == null && root.right == null))
				return true;
			return (isPathSum(root.left, sum, root.val) || isPathSum(root.right, sum, root.val));
		}	
		
	    public boolean hasPathSum(TreeNode root, int sum) {
	        return isPathSum(root, sum, 0);
	    }
	}
}
