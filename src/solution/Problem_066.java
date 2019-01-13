package solution;

import java.util.Arrays;

public class Problem_066 {
	
	class Solution {
		public int[] plusOne(int[] digits) {
			digits[digits.length - 1]++;
			int i = 1;
			while (digits[digits.length - i] == 10) {
				digits[digits.length - i] = 0;
				i++;
				if (i != digits.length + 1)
					digits[digits.length - i]++;
				else {
					int[] new_digits = new int[digits.length + 1];
					new_digits[0] = 1;
					for (int j = 0; j < digits.length; j++)
						new_digits[j + 1] = digits[j];
					return new_digits;
				}

			}
			return digits;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();

		int[] nums = new int[] { 4 };
		System.out.println(Arrays.toString(solution.plusOne(nums)));
		nums = new int[] { 9 };
		System.out.println(Arrays.toString(solution.plusOne(nums)));
	}
}
