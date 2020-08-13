package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.ListNode;

// 206
// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head == null) {
        	return head;
        }else if(head.next == null) {
        	return head;
        }else {
        	ListNode reversed = reverseList(head.next);
        	head.next.next = head;
        	head.next = null;
        	return reversed;
        }
    }
}
