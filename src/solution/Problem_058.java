package solution;

public class Problem_058 {
	
	class Solution {
		public int lengthOfLastWord(String s) {
			int ans = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				if (i == s.length() - 1)
					while (s.charAt(i) == ' ') {
						i--;
						if (i == -1)
							return 0;
					}
				if (s.charAt(i) == ' ')
					break;
				ans++;
			}
			return ans;
		}
	}
	
	class Solution_2 {
		public int lengthOfLastWord(String s) {
			int max = 0;
			for (int i = 0; i < s.length(); i++) {
				int temp = 0;
				while (s.charAt(i) != ' ') {
					temp++;
					i++;
					if (i == s.length())
						break;
				}
				max = max > temp ? max : temp;
			}
			return max;
		}
	}

	public void TestCase() {
		Solution solution = new Solution();

		System.out.println("---- 求字符串尾部的单词长度 ----");
		System.out.println(solution.lengthOfLastWord("Hello World"));
		System.out.println(solution.lengthOfLastWord(" "));
		System.out.println(solution.lengthOfLastWord("a"));
		System.out.println(solution.lengthOfLastWord(" TJqWC"));
		System.out.println(solution.lengthOfLastWord("Today is a nice day"));
		System.out.println(solution.lengthOfLastWord("a "));
		
		System.out.println("---- 求字符串中的最长单词 ----");
		Solution_2 solution2 = new Solution_2();

		System.out.println(solution2.lengthOfLastWord("Hello World"));
		System.out.println(solution2.lengthOfLastWord(" "));
		System.out.println(solution2.lengthOfLastWord("a"));
		System.out.println(solution2.lengthOfLastWord(" TJqWC"));
		System.out.println(solution2.lengthOfLastWord("Today is a nice day"));
		System.out.println(solution2.lengthOfLastWord("a "));
	}
}
