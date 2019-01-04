package solution;

public class Problem_038 {
	class Solution {
		public String countAndSay(int n) {
			if (n == 1) {
				return "1";
			} else {
				char[] parent = countAndSay(n - 1).toCharArray();
				char[] child = new char[2 * parent.length];
				int child_sequence = 0;
				for (int i = 0; i < parent.length; i++) {
					int count = 1;
					while ((i + 1) < parent.length && parent[i] == parent[i + 1]) {
						count++;
						i++;
					}
					child[child_sequence] = (char) (count + '0');
					child[child_sequence + 1] = parent[i];
					child_sequence += 2;
				}
				return new String(child, 0, child_sequence);
			}
		}
	}

	public void TestCase() {
		Solution solution = new Solution();

		for (int i = 11; i < 15; i++) {
			System.out.println(solution.countAndSay(i));
		}
	}
}
