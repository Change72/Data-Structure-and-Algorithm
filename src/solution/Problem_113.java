package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem_113 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	// 113	
	// 正向向下
	class Solution {
		private List<List<Integer>> dynamicMatrix;

		public Solution() {
			this.dynamicMatrix = new ArrayList<List<Integer>>();
		}

		public void isPathSum(TreeNode root, int sum, int totalValue, List<Integer> current) {
			if (root == null)
				return;
			current.add(root.val);
			totalValue = root.val + totalValue;
			if (totalValue == sum && (root.left == null && root.right == null))
				dynamicMatrix.add(current);
			List<Integer> new_current = new ArrayList<Integer>();
			for (int i = 0; i < current.size(); i++)
				new_current.add(current.get(i));
			isPathSum(root.left, sum, totalValue, current);
			isPathSum(root.right, sum, totalValue, new_current);
		}

		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			isPathSum(root, sum, 0, new ArrayList<Integer>());
			return dynamicMatrix;
		}
	}
	
	// 反向向上
	public static class Solution_2 {
		public List<List<Integer>> isPathSum(TreeNode root, int sum, int totalValue) {
			totalValue = root.val + totalValue;
			List<List<Integer>> dynamicMatrix = new ArrayList<List<Integer>>();
			if (totalValue == sum && (root.left == null && root.right == null)) {
				List<Integer> current = new ArrayList<Integer>(Arrays.asList(root.val));
				dynamicMatrix.add(current);
				return dynamicMatrix;
			}
			List<List<Integer>> left = null;
			if(root.left != null)
				left = isPathSum(root.left, sum, totalValue);
			List<List<Integer>> right = null;
			if(root.right != null)
				right = isPathSum(root.right, sum, totalValue);
			if(left == null && right == null)
				return null;
			else if (left != null && right != null) {
				for (List<Integer> list : left) {
					list.add(0, root.val);
				}
				for (List<Integer> list : right) {
					list.add(0, root.val);
					left.add(list);
				}
				return left;
			} else if (left != null) {
				for (List<Integer> list : left) {
					list.add(0, root.val);
				}
				return left;
			}
			else {
				for (List<Integer> list : right) {
					list.add(0, root.val);
				}
				return right;
			}
		}

		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			if(root == null)
				return new ArrayList<List<Integer>>();
			List<List<Integer>> ans = isPathSum(root, sum, 0);
			if(ans == null)
				return new ArrayList<List<Integer>>();
			return ans;
		}	
	}
	
	// 网上的方法
	// beats 100%, 但内存消耗比前两个大
	public static class Solution_3{
		private List<List<Integer>> dynamicMatrix;
		private List<Integer> dynamicList;
		
		public Solution_3() {
			this.dynamicMatrix = new ArrayList<List<Integer>>();
			this.dynamicList = new ArrayList<Integer>();
		} 
		
		
		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			if (root == null)
				return dynamicMatrix;
			dfs(root, 0, sum);
			return dynamicMatrix;
		}

		private void dfs(TreeNode node, int sum, int target) {
			dynamicList.add(node.val);

			if (node.left == null && node.right == null) {
				if (sum + node.val == target)
					dynamicMatrix.add(new ArrayList<>(dynamicList));
			} else {
				if (node.left != null)
					dfs(node.left, sum + node.val, target);

				if (node.right != null)
					dfs(node.right, sum + node.val, target);
			}

			dynamicList.remove(dynamicList.size() - 1);
		}
		
	}
}
