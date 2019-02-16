package solution;

public class Problem_083 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode iterator = head;
			while (iterator.next != null)
				if (iterator.val == iterator.next.val)
					iterator.next = iterator.next.next;
				else
					iterator = iterator.next;
			return head;
		}
	}

	public void TestCase() {
		Solution solution = new Solution();
		int[] l1_nums = new int[] { 2, 4, 3, 6 };
		int[] l2_nums = new int[] { 5, 5, 6, 6, 4, 4, 4, 4, 4, 9, 9 };
		ListNode l1_head = new ListNode(0);
		ListNode l2_head = new ListNode(0);
		ListNode l1_iterator = l1_head;
		ListNode l2_iterator = l2_head;

		for (int i = 0; i < l1_nums.length; i++) {
			ListNode temp = new ListNode(l1_nums[i]);
			l1_iterator.next = temp;
			l1_iterator = temp;
		}

		for (int i = 0; i < l2_nums.length; i++) {
			ListNode temp = new ListNode(l2_nums[i]);
			l2_iterator.next = temp;
			l2_iterator = temp;
		}

		ListNode ans = solution.deleteDuplicates(l2_head.next);
		while (true) {
			System.out.println(ans.val);
			if (ans.next == null)
				break;
			ans = ans.next;
		}
	}
}
