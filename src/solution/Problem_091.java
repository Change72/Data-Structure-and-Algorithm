package solution;

public class Problem_091 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static class Solution {
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head == null)
	        	return null;
	        ListNode begin = new ListNode(0);
	        ListNode end = new ListNode(0);
	        ListNode iterator = head;
	        ListNode subTag = null;
	        ListNode subEnd = new ListNode(0);
	        int location = 1;
	        while(iterator != null) {
        		if(location == m - 1) {
        			begin.next = iterator;
        		}
	        	if(location == n + 1) {
	        		end.next = iterator;
	        	}
	        	if(location > m - 1 && location < n + 1) {
	        		ListNode temp = new ListNode(iterator.val);
	        		temp.next = subTag;
	        		if(subTag == null)
	        			subEnd.next = temp;
	        		subTag = temp;
	        	}
	        	location ++;
	        	iterator = iterator.next;	
	        }
	        if(end.next != null)
	        	subEnd.next.next = end.next;
	        if(begin.next != null) {
	        	// 如果倒序节点前有链，则链接
	        	begin.next.next = subTag;
	        	return head;
	        }
	        return subTag;
	    }
	}
}
