package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (slow != null && fast != null) {
			fast = fast.next;
			slow = slow.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (fast == slow && slow != null) {
				return true;
			}
		}
		return false;
	}
}
