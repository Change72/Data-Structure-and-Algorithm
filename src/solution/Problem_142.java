package solution;

import java.util.HashMap;
import java.util.Map;

public class Problem_142 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
	        for(int i = 0; head != null; i ++, head = head.next)
	            if(map.containsKey(head))
	                return head;
	            else
	                map.put(head, i);        
	        return null;
	    }
	}
	/*
	 * 这里有一个数学的trick 
	 * 即 两个哨兵相逢后，一个回到起点，两个哨兵同步走，再次相遇时一定是 环起点
	 * 证明如下：
	 * 		假设 速度慢的哨兵，入环前走了A步，入环后走了B步，环长度为x，速度快的哨兵已经走了k圈
	 * 则有：
	 * 		A + B + kx = 2(A + B)
	 * 即：
	 * 		A = kx - B
	 * 然后将一个哨兵置回起点，其入环需要A步
	 * 另一个哨兵此时也走A步，之前走了B步，正好走回环起点
	 */
	public class Solution_2 {
	    public ListNode detectCycle(ListNode head) {
	        ListNode first = head;
	        ListNode second = head;
	        while(second != null){
	            first = first.next;
	            second = second.next;
	            if(second != null)
	                second = second.next;
	            else
	                return null;
	            if(first == second){
	                first = head;
	                while(first != second){
	                    first = first.next;
	                    second = second.next;
	                }
	                return first;
	            }
	        }
	        return null;
	    }
	}
}
