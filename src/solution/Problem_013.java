package solution;

import java.util.HashMap;
import java.util.Map;

public class Problem_013 {
	class Solution {
		public int romanToInt(String s) {
			Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
			dictionary.put('I', 1);
			dictionary.put('V', 5);
			dictionary.put('X', 10);
			dictionary.put('L', 50);
			dictionary.put('C', 100);
			dictionary.put('D', 500);
			dictionary.put('M', 1000);
			// 字母i 的右侧，如果大于dic(i)，则减法；否则继续加
			int ans = 0;
			for (int i = 0; i < s.length(); i++) {
				if (i + 1 < s.length() && dictionary.get(s.charAt(i)) < dictionary.get(s.charAt(i + 1))) {
					ans = ans + dictionary.get(s.charAt(i + 1)) - dictionary.get(s.charAt(i));
					i = i + 1;
				} else
					ans = ans + dictionary.get(s.charAt(i));
			}
			return ans;
		}
	}

	public void TestCase() {
		Solution solution = new Solution();

		System.out.println(solution.romanToInt("III"));
		System.out.println(solution.romanToInt("IV"));
		System.out.println(solution.romanToInt("IX"));
		System.out.println(solution.romanToInt("LVIII"));
		System.out.println(solution.romanToInt("MCMXCIV"));
		System.out.println(solution.romanToInt("IM"));
	}
}
