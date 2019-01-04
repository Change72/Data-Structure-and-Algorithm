package solution;

import java.util.ArrayList;
import java.util.List;

public class Problem_009 {
	class Solution {
		public boolean isPalindrome(int x) {
			if (x < 0)
				return false;
			List<Integer> temp = new ArrayList<Integer>();
			int length = 0;
			while (x / 10 != 0) {
				temp.add(x % 10);
				x = x / 10;
				length++;
			}
			temp.add(x);
			int i = 0;
			if (length % 2 == 0) {
				while (temp.get(length) == temp.get(i) && i != length) {
					i++;
					length--;
				}
				if (i == length)
					return true;
				else
					return false;
			} else {
				while (temp.get(length) == temp.get(i) && i != length - 1) {
					i++;
					length--;
				}
				if (temp.get(length) == temp.get(i) && i == length - 1)
					return true;
				else
					return false;
			}
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		
		System.out.println(solution.isPalindrome(121));
		System.out.println(solution.isPalindrome(-121));
		System.out.println(solution.isPalindrome(10));
	}
}
