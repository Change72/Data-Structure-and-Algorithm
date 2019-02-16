package solution;

public class Problem_101 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

//  101	
	public static class Solution {
		public boolean childSymmetric(TreeNode p, TreeNode q) {
			if (p == null && q == null)
				return true;
			if (p == null || q == null)
				return false;
			if (p.val == q.val)
				return childSymmetric(p.left, q.right) && childSymmetric(p.right, q.left);
			return false;
		}
		
	    public boolean isSymmetric(TreeNode root) {
	    	if(root == null)
	    		return true;	
	        return childSymmetric(root.left, root.right);
	    }
	}
}
