package solution;

import java.util.ArrayList;
import java.util.List;

public class Problem_007 {
	class Solution {
		public int reverse(int x) {
			int answer = 0;
			int length = 0;
			List<Integer> temp = new ArrayList<Integer>();
			while (x / 10 != 0) {
				temp.add(x % 10);
				x = x / 10;
				length++;
			}
			temp.add(x);
			for (int i = 0; i <= length; i++) {
				answer = (int) (answer + temp.get(i) * Math.pow(10, length - i));
				if (i == length) {
					if (((long) answer + temp.get(i) * Math.pow(10, length - i) > 2147483647)
							|| ((long) answer + temp.get(i) * Math.pow(10, length - i) < -2147483648))
						answer = 0;
				}
			}
			return answer;
		}
	}
	
	class Solution_2 {
		public int reverse(int x) {
			int answer = 0;
			while (x / 10 != 0) {
				int num = x % 10;
				x = x / 10;
				answer = answer * 10 + num;
			}
			if ((answer > (Integer.MAX_VALUE / 10) || answer == (Integer.MAX_VALUE / 10) && x > 7)
					|| (answer < (Integer.MIN_VALUE / 10) || answer == (Integer.MIN_VALUE / 10) && x < -8))
				return 0;
			else
				return answer * 10 + x;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		Solution_2 solution_2 = new Solution_2();
		
		System.out.println("---     First Solution    ---");
		System.out.println("--    使用 数组 传统的除十取余  --");
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(1230));
		System.out.println(solution.reverse(-2147483648));
		
		System.out.println("---    Second Solution    ---");
		System.out.println("--       答案提示的方法            --");
		System.out.println(solution_2.reverse(123));
		System.out.println(solution_2.reverse(-123));
		System.out.println(solution_2.reverse(1230));
		System.out.println(solution_2.reverse(-2147483648));
	}
}
