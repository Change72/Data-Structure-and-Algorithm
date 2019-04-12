package solution;

public class Problem_141 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        ListNode first = head;
	        ListNode second = head;
	        while(second != null){
	            first = first.next;
	            second = second.next;
	            if(second != null)
	                second = second.next;
	            else
	                return false;
	            if(first == second)
	                return true;
	        }
	        return false;
	    }
	}
}
