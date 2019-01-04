package solution;

import java.util.HashMap;
import java.util.Map;

public class Problem_020 {
	/**
	 * 基于数组实现的顺序栈
	 * 
	 * @param <E>
	 */
	class Stack<E> {
		private Object[] data = null;
		private int maxSize = 0; // 栈容量
		private int top = -1; // 栈顶指针

		/**
		 * 构造函数：根据给定的size初始化栈
		 */
		Stack() {
			this(5); // 默认栈大小为10
		}

		Stack(int initialSize) {
			if (initialSize >= 0) {
				this.maxSize = initialSize;
				data = new Object[initialSize];
				top = -1;
			} else {
				throw new RuntimeException("初始化大小不能小于0：" + initialSize);
			}
		}

		// 判空
		public boolean empty() {
			return top == -1 ? true : false;
		}

		// 进栈,第一个元素top=0；
		public boolean push(E e) {
			if (top == maxSize - 1) {
				throw new RuntimeException("栈已满，无法将元素入栈！");
			} else {
				data[++top] = e;
				return true;
			}
		}

		// 查看栈顶元素但不移除
		@SuppressWarnings("unchecked")
		public E peek() {
			if (top == -1) {
				throw new RuntimeException("栈为空！");
			} else {
				return (E) data[top];
			}
		}

		// 弹出栈顶元素
		@SuppressWarnings("unchecked")
		public E pop() {
			if (top == -1) {
				throw new RuntimeException("栈为空！");
			} else {
				return (E) data[top--];
			}
		}

		// 返回对象在堆栈中的位置，以 1 为基数
		public int search(E e) {
			int i = top;
			while (top != -1) {
				if (peek() != e) {
					top--;
				} else {
					break;
				}
			}
			int result = top + 1;
			top = i;
			return result;
		}
	}
	
	class Solution {
		public boolean isValid(String s) {
			Stack<Character> stack = new Stack<Character>();
			Map<Character, Character> map = new HashMap<Character, Character>();
			map.put('(', ')');
			map.put('[', ']');
			map.put('{', '}');
			for (int i = 0; i < s.length(); i++) {
				if (map.containsKey(s.charAt(i)))
					stack.push(s.charAt(i));
				else {
					if (stack.empty())
						return false;
					if (map.get(stack.pop()) != s.charAt(i))
						return false;
				}
			}
			if (stack.empty())
				return true;
			else
				return false;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		
		System.out.println(solution.isValid("()"));
		System.out.println(solution.isValid("()[]{}"));
		System.out.println(solution.isValid("(]"));
		System.out.println(solution.isValid("([)]"));
		System.out.println(solution.isValid("{[]}"));
		System.out.println(solution.isValid(""));
	}
}
