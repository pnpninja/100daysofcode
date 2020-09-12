package edu.stonybrook.pnarendra.hard;

import edu.stonybrook.pnarendra.data_structures.ListNode;

// 25
// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null) {
			return head;
		}else if(head.next == null) {
			return head;
		}else {
			int count = 0;
			ListNode tempHead = head;
			ListNode prev = null;
			while(count < k && tempHead != null) {
				prev = tempHead;
				tempHead = tempHead.next;
				count++;
			}
			
			if(tempHead == null && count == k) {
				return reverseList(head);
			}else if(tempHead == null) {
				return head;
			}else {
				prev.next = null;
				ListNode temp3 = reverseList(head);
				ListNode temp2 = reverseKGroup(tempHead, k);
				head.next = temp2;
				return temp3;
				
			}
		}
		
    }
	
	private ListNode reverseList(ListNode head) {
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
	
	public static void main(String[] args) {
		ListNode temp = new ListNode(1);
		temp.next = new ListNode(2);
		//temp.next.next = new ListNode(3);
		//temp.next.next.next = new ListNode(4);
		//temp.next.next.next.next = new ListNode(5);
		ListNode xx = new ReverseKGroup().reverseKGroup(temp, 2);
		System.out.println("DAONE");
	}

}
