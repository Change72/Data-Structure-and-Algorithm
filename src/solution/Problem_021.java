package solution;

public class Problem_021 {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode head = new ListNode(0);
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			if (l1.val <= l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			ListNode node = head.next;
			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					node.next = l1;
					l1 = l1.next;
				} else {
					node.next = l2;
					l2 = l2.next;
				}
				node = node.next;
			}

			if (l1 == null)
				node.next = l2;
			if (l2 == null)
				node.next = l1;

			return head.next;
		}
	}
	
	public void TestCase() {
		Solution solution = new Solution();
		
		int[] l1_nums = new int[] {2,3,4,6};
		int[] l2_nums = new int[] {4,4,5,6,7,8,9,10};
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
		
		ListNode ans = solution.mergeTwoLists(l1_head.next, l2_head.next);
		while (true) {
			System.out.println(ans.val);
			if (ans.next == null)
				break;
			ans = ans.next;
		}
	}
}
