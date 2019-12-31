package medium;

import general.ListNode;

public class LinkedListFindCycleStartNode_142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1->3->2->0->4->loop to 2
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur.next = new ListNode(3);
		cur=cur.next;
		ListNode loopStart = new ListNode(2);
		cur.next = loopStart;
		cur=cur.next;
		cur.next = new ListNode(0);
		cur=cur.next;
		cur.next = new ListNode(4);
		cur=cur.next;
		cur.next = loopStart;
		ListNode res = detectCycle(head);
		if(res == null)
			System.out.println("No Cycle");
		else
			System.out.println(res.val);

	}

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	    public static ListNode detectCycle(ListNode head) {
	        boolean cycleDetected = false;
	        ListNode slow = head, fast = head;
	        //System.out.println("fast.next = "+ fast.next);
	        while(slow != null && fast != null && fast.next != null){
	          //  System.out.println("in while");
	            slow = slow.next;
	            fast = fast.next.next;
	            if(slow == fast){
	                cycleDetected = true;
	                break;
	            }
	        }
	        if(slow == null || fast == null)
	            return null;
	        if(cycleDetected){
	            int cycleLength = 1;
	            fast = fast.next;
	            while(slow != fast){
	                cycleLength++;
	                fast = fast.next;
	            }
	            ListNode start=head, ahead = head;
	            while(cycleLength >0){
	                ahead = ahead.next;
	                cycleLength--;                
	            }
	            while(start!=ahead){
	                start= start.next;
	                ahead = ahead.next;
	            }
	            return start;
	        }
	        return null;
	    }
}
