package solution;

public class Problem_028 {
	
	class Solution {
		public int strStr(String haystack, String needle) {
			if (needle.isEmpty())
				return 0;
			for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
				if (haystack.charAt(i) == needle.charAt(0)) {
					if (needle.equals(haystack.substring(i, Math.min(haystack.length(), i + needle.length()))))
						return i;
				}
			}
			return -1;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		
		System.out.println(solution.strStr("hello", "ll"));
		System.out.println(solution.strStr("aaaaa", "bba"));
		System.out.println(solution.strStr("a", "a"));
	}
}
