package solution;

import java.util.HashMap;
import java.util.Map;

public class Problem_070 {
	/**
	 * @author change
	 * 典型的动态规划 —— 分阶段求解问题的思想，一个问题将其分解为 前一个 或 几个 阶段求解
	 * 		利用自底向上的递推方式，实现时间和空间的最优化
	 * 重点注意：
	 * 		1. 最优子结构 eg. F(10) = F(9) + F(8), i.e. F(8) and F(9) are the best sub structure
	 * 		2. 边界 eg. F(1) = 1, and F(2) = 2
	 * 		3. 状态转移公式 eg. F(n) = F(n - 1) + F(n - 2)
	 * 
	 */
	class Solution {
		// 时间复杂度 O(2^n)，二叉树状递归，n-1 层，接近 2^(n-1) 个计算节点
		public int climbStairs(int n) {
			if (n < 0)
				return 0;
			else if (n == 1)
				return 1;
			else if (n == 2)
				return 2;
			else
				return climbStairs(n - 1) + climbStairs(n - 2);
		}

		// 优化方法一：使用 HashMap 记录使用过的值 【备忘录算法】
		// 优化效果：时间复杂度 O(n)， 空间复杂度 O(n)
		public int climbStairs2(int n, Map<Integer, Integer> map) {
			if (n < 0)
				return 0;
			else if (n == 1)
				return 1;
			else if (n == 2)
				return 2;
			else {
				if (map.containsKey(n))
					return map.get(n);
				else {
					int value = climbStairs(n - 1) + climbStairs(n - 2);
					map.put(n, value);
					return value;
				}
			}
		}

		// 优化方法二：思路逆转【动态规划】
		// 优化效果：时间复杂度 O(n)， 空间复杂度 O(1)
		public int climbStairs3(int n) {
			if (n < 0)
				return 0;
			else if (n == 1)
				return 1;
			else if (n == 2)
				return 2;
			else {
				int a = 1, b = 2;
				int ans = 0;
				for (int i = 3; i <= n; i++) {
					ans = a + b;
					a = b;
					b = ans;
				}
				return ans;
			}
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		System.out.println("---- 暴力解法 时间复杂度 O(2^n) ----");
		System.out.println(solution.climbStairs(6));

		System.out.println("-- 使用 HashMap 记录使用过的值 【备忘录算法】 --");
		System.out.println(solution.climbStairs2(6, new HashMap<Integer, Integer>()));

		System.out.println("---- 思路逆转【动态规划】 ----");
		System.out.println(solution.climbStairs(6));
	}
}