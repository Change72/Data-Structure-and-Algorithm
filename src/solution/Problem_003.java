package solution;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_003 {
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			for (int i = 0; i < s.length() - max; i++) {
				// 每前进一步都构建一个集合
				Set<Character> set = new HashSet<Character>();
				set.add(s.charAt(i));
				for (int j = i + 1; j < s.length(); j++) {
					if (set.contains(s.charAt(j))) {
						break;
					} else {
						set.add(s.charAt(j));
					}
				}
				if (max < set.size())
					max = set.size();
			}
			return max;
		}
	}

	class Solution_2 {
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < s.length(); i++) {
				if (map.containsKey(s.charAt(i))) {
					// 如果 map 中的 key 已包含当前字符
					int location = map.get(s.charAt(i));
					Collection<Integer> values = map.values();
					// 使用 Collection 后逐一将前面的移出 map
					while (map.containsValue(location)) {
						values.remove(location);
						location--;
					}
				}
				map.put(s.charAt(i), i);
				if (max < map.size())
					max = map.size();
			}
			return max;
		}
	}

	class Solution_3 {
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int head = 0, end = 0; end < s.length(); end++) {
				Character target = s.charAt(end);
				// 遇到相同移掉旧的插入新的，并更新head位置
				if (map.containsKey(target) && map.get(target) >= head) {
					head = map.get(target) + 1;
					map.remove(target);
				}
				map.put(target, end);
				if (max < end - head + 1)
					max = end - head + 1;

			}
			return max;
		}
	}
	
	class Solution_4 {
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < s.length(); i++) {
				if (map.containsKey(s.charAt(i))) {
					int location = map.get(s.charAt(i));
					map.clear();
					// 遇到相同的清空 map，然后将目标重新加进来
					// 与2不同的是，2是逆向删除，4是清空后重新添加
					while (location < i) {
						location++;
						map.put(s.charAt(location), location);
					}
				}
				map.put(s.charAt(i), i);
				if (max < map.size())
					max = map.size();
			}
			return max;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		Solution_2 solution_2 = new Solution_2();
		Solution_3 solution_3 = new Solution_3();
		Solution_4 solution_4 = new Solution_4();
		
		int ans = 0;
		
		String string1 = "abcabcbb";
		String string2 = " ";
		String string3 = "sfdklajfksla";
		String string4 = "dvdf";
		
		
		System.out.println("---     First Solution    ---");
		System.out.println("-- 使用 集合Set 每步都向后枚举  --");
		ans = solution.lengthOfLongestSubstring(string1);
		System.out.println(ans);
		ans = solution.lengthOfLongestSubstring(string2);
		System.out.println(ans);
		ans = solution.lengthOfLongestSubstring(string3);
		System.out.println(ans);
		ans = solution.lengthOfLongestSubstring(string4);
		System.out.println(ans);
		
		System.out.println("---    Second Solution    ---");
		System.out.println("-- 使用 HashMap 遇到相同字符将前面的移出map --");
		ans = solution_2.lengthOfLongestSubstring(string1);
		System.out.println(ans);
		ans = solution_2.lengthOfLongestSubstring(string2);
		System.out.println(ans);
		ans = solution_2.lengthOfLongestSubstring(string3);
		System.out.println(ans);
		ans = solution_2.lengthOfLongestSubstring(string4);
		System.out.println(ans);
		
		System.out.println("---     Third Solution    ---");
		System.out.println("-- 使用 HashMap 并用头尾哨兵记录位置（更优）  --");
		ans = solution_3.lengthOfLongestSubstring(string1);
		System.out.println(ans);
		ans = solution_3.lengthOfLongestSubstring(string2);
		System.out.println(ans);
		ans = solution_3.lengthOfLongestSubstring(string3);
		System.out.println(ans);
		ans = solution_3.lengthOfLongestSubstring(string4);
		System.out.println(ans);
		
		System.out.println("---     Fourth Solution    ---");
		System.out.println("-- 使用 HashMap 遇到相同字符清空，重新加  --");
		ans = solution_4.lengthOfLongestSubstring(string1);
		System.out.println(ans);
		ans = solution_4.lengthOfLongestSubstring(string2);
		System.out.println(ans);
		ans = solution_4.lengthOfLongestSubstring(string3);
		System.out.println(ans);
		ans = solution_4.lengthOfLongestSubstring(string4);
		System.out.println(ans);
		
	}
}
