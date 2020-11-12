package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.ListNode;

public class RemoveDuplicatesFromSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;
        while(iter != null) {
        	ListNode temp = iter.next;
        	while(temp!=null && temp.val == iter.val) {
        		temp = temp.next;
        	}
        	iter.next = temp;
        	iter = temp;
        }
        return head;
    }

}
