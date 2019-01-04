package solution;

import java.util.ArrayList;
import java.util.List;

public class Problem_002 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; } }
	 */

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			List<Integer> first = new ArrayList<Integer>();
			List<Integer> second = new ArrayList<Integer>();
			int firstLength = 0;
			int secondLength = 0;
			while (l1.next != null) {
				first.add(l1.val);
				firstLength++;
				l1 = l1.next;
			}
			first.add(l1.val);
			while (l2.next != null) {
				second.add(l2.val);
				secondLength++;
				l2 = l2.next;
			}
			second.add(l2.val);

			ListNode head = new ListNode(0);
			ListNode node = new ListNode(0);
			head = node;
			int carry = 0;
			
			while (firstLength >= 0 && secondLength >= 0) {
				int value = first.get(firstLength) + second.get(secondLength) + carry;
				if (value > 9) {
					carry = 1;
					value -= 10;
				}else 
					carry = 0;
				ListNode iterator = new ListNode(value);
				node.next = iterator;
				node = iterator;
				firstLength--;
				secondLength--;
			} 
			
			while (firstLength >= 0) {
				int value = first.get(firstLength) + carry;
				if (value > 9) {
					carry = 1;
					value -= 10;
				}else
					carry = 0;
				ListNode iterator = new ListNode(value);
				node.next = iterator;
				node = iterator;
				firstLength--;
			} 
			
			while (secondLength >= 0) {
				int value = second.get(secondLength) + carry;
				if (value > 9) {
					carry = 1;
					value -= 10;
				}else
					carry = 0;
				ListNode iterator = new ListNode(value);
				node.next = iterator;
				node = iterator;
				secondLength--;
			} 
			
			if (carry > 0) {
				ListNode iterator = new ListNode(carry);
				node.next = iterator;
			}

			return head.next;
		}
	}

	class Solution_2 {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode head = new ListNode(0);
			ListNode node = head;
			int carry = 0;

			while (true) {
				int value = l1.val + l2.val + carry;
				if (value > 9) {
					carry = 1;
					value -= 10;
				} else {
					carry = 0;
				}
				ListNode iterator = new ListNode(value);
				node.next = iterator;
				node = iterator;
				if (l1.next == null && l2.next == null) {
					if (carry == 1)
						node.next = new ListNode(1);
					return head.next;
				}
				if (l1.next == null) {
					while (true) {
						l2 = l2.next;
						value = l2.val + carry;
						if (value > 9) {
							carry = 1;
							value -= 10;
						} else {
							carry = 0;
						}
						iterator = new ListNode(value);
						node.next = iterator;
						node = iterator;
						if (l2.next == null) {
							if (carry == 1)
								node.next = new ListNode(1);
							return head.next;
						}
					}

				}
				if (l2.next == null) {
					while (true) {
						l1 = l1.next;
						value = l1.val + carry;
						if (value > 9) {
							carry = 1;
							value -= 10;
						} else {
							carry = 0;
						}
						iterator = new ListNode(value);
						node.next = iterator;
						node = iterator;
						if (l1.next == null) {
							if (carry == 1)
								node.next = new ListNode(1);
							return head.next;
						}
					}
				}
				l1 = l1.next;
				l2 = l2.next;
			}
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		Solution_2 solution_2 = new Solution_2();
		
		int[] l1_nums = new int[] {2,4,3,6};
		int[] l2_nums = new int[] {5,6,4,4};
		ListNode l1_head = new ListNode(0);
		ListNode l2_head = new ListNode(0);
		ListNode l1_iterator = l1_head; 
		ListNode l2_iterator = l2_head; 
		
		for(int i = 0; i < l1_nums.length; i ++ ) {
			ListNode temp = new ListNode(l1_nums[i]);
			l1_iterator.next = temp;
			l1_iterator = temp;
		}
		
		for(int i = 0; i < l2_nums.length; i ++ ) {
			ListNode temp = new ListNode(l2_nums[i]);
			l2_iterator.next = temp;
			l2_iterator = temp;
		}
		
		System.out.println("---     First Solution    ---");
		System.out.println("--      使用 数组 实现倒序相加  --");
		ListNode ans = solution.addTwoNumbers(l1_head.next, l2_head.next);
		while (true) {
			System.out.println(ans.val);
			if (ans.next == null)
				break;
			ans = ans.next;
		}
		
		System.out.println("---    Second Solution    ---");
		System.out.println("--   使用 链表 实现正序相加（ans）    --");
		ListNode ans2 = solution_2.addTwoNumbers(l1_head.next, l2_head.next);
		while (true) {
			System.out.println(ans2.val);
			if (ans2.next == null)
				break;
			ans2 = ans2.next;
		}
	}
}
