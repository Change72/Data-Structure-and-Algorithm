package solution;

public class Problem_067 {
	class Solution {
		public String addBinary(String a, String b) {
			if (a.length() == 0)
				return b;
			if (b.length() == 0)
				return a;
			StringBuilder ans = new StringBuilder();
			int carry = 0;
			for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
				if (i < 0) {
					while (j >= 0) {
						int val = (int) b.charAt(j) + carry - '0';
						if (val > 1) {
							ans.insert(0, val - 2);
							carry = 1;
						} else {
							ans.insert(0, val);
							carry = 0;
						}
						j--;
					}
					break;
				}
				if (j < 0) {
					while (i >= 0) {
						int val = (int) a.charAt(i) + carry - '0';
						if (val > 1) {
							ans.insert(0, val - 2);
							carry = 1;
						} else {
							ans.insert(0, val);
							carry = 0;
						}
						i--;
					}
					break;
				}
				int value = a.charAt(i) - '0' + (int) b.charAt(j) - '0' + carry;
				if (value > 1) {
					ans.insert(0, value - 2);
					carry = 1;
				} else {
					ans.insert(0, value);
					carry = 0;
				}
			}
			if (carry > 0)
				ans.insert(0, 1);
			return ans.toString();
		}
	}
	
	// 对不超过long长度的字符串
	class Solution_2 {
		public String addBinary(String a, String b) {
			long target = Long.valueOf(a) + Long.valueOf(b);
			StringBuilder ans = new StringBuilder();
			int carry = 0;
			while (target != 0 || carry != 0) {
				if (target % 10 + carry > 1) {
					ans.insert(0, target % 10 + carry - 2);
					carry = 1;
					target = target / 10;
				} else {
					ans.insert(0, target % 10 + carry);
					carry = 0;
					target = target / 10;
				}

			}
			return ans.toString();
		}
	}
	
	
	
	public void TestCase() {
		Solution solution = new Solution();
		System.out.println("---- 通用解法 ----");
		System.out.println(solution.addBinary("1010", "1011"));
		System.out.println(solution.addBinary("11", "1"));
		System.out.println(solution.addBinary(
				"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

		System.out.println("---- 对于长度较短的解法 ----");
		Solution_2 solution2 = new Solution_2();
		System.out.println(solution2.addBinary("1010", "1011"));
		System.out.println(solution2.addBinary("11", "1"));
	}
}
