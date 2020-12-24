package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.ListNode;

public class OddEvenLinkedList {
	
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
        	return head;
        }
        
        ListNode headCopy = head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode prevOddHead = null;
        ListNode prevEvenHead = null;
        ListNode evenHeadCopy = head.next;
        int swtch = 1;
        while(true) {
        	if(swtch == 1) {
        		if(oddHead.next != null) {
        			oddHead.next = oddHead.next.next;
        			prevOddHead = oddHead;
        			oddHead = oddHead.next;
        		}else {
                    if(evenHead == null){
                        break;
                    }else {
            			evenHead.next = evenHead.next.next;
            			prevEvenHead = evenHead;
            			evenHead = evenHead.next;
            		}
        			break;
        		}
        		swtch = 0;
        	}else {
        		if(evenHead.next != null) {
        			evenHead.next = evenHead.next.next;
        			prevEvenHead = evenHead;
        			evenHead = evenHead.next;
        		}else {
                    if(oddHead == null){
                        break;
                    }else {
            			oddHead.next = oddHead.next.next;
            			prevOddHead = oddHead;
            			oddHead = oddHead.next;
            		}
        			break;
        		}
        		swtch = 1;
        	}
        }
        if(oddHead != null) {
        	oddHead.next = evenHeadCopy;
        }else {
        	prevOddHead.next = evenHeadCopy;
        }
        return head;
    }

}
