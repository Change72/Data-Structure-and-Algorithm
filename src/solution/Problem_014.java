package solution;

public class Problem_014 {
	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0)
				return "";
			if (strs.length == 1)
				return strs[0];
			int ans = 0;
			int min = Integer.MAX_VALUE;
			while (ans < min) {
				for (int i = 0; i < strs.length; i++) {
					if (strs[i].length() == 0)
						return "";
					if (i + 1 < strs.length) {
						if (strs[i + 1].length() == 0)
							return "";
						if (strs[i].charAt(ans) != strs[i + 1].charAt(ans))
							return strs[0].substring(0, ans);
					}
					if (ans == 0)
						min = min < strs[i].length() ? min : strs[i].length();
				}
				ans = ans + 1;
			}
			return strs[0].substring(0, ans);
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		
		String[] test = new String[] { "dog", "racecar", "car" };
		System.out.println(solution.longestCommonPrefix(test));

		String[] test2 = new String[] { "flower","flow","flight" };
		System.out.println(solution.longestCommonPrefix(test2));
		
		String[] test3 = new String[] { "abab","aba","" };
		System.out.println(solution.longestCommonPrefix(test3));
		
		String[] test4 = new String[] { "a" };
		System.out.println(solution.longestCommonPrefix(test4));
		
		String[] test5 = new String[] { "","" };
		System.out.println(solution.longestCommonPrefix(test5));
		
		String[] test6 = new String[] { "c","c" };
		System.out.println(solution.longestCommonPrefix(test6));
	}
}
