package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.ListNode;

public class SortList {
	
	public ListNode sortList(ListNode head) {
        return sortListHelper(head);
    }
	
	public ListNode sortListHelper(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		if(head.next.next == null) {
			if(head.val > head.next.val) {
				ListNode tempHead = head.next;
				head.next.next = head;
				head.next = null;
				return tempHead;
			}else {
				return head;
			}
		}
		ListNode leftSide = head;
		ListNode prevMiddleNode = findMiddleNode(head);
		ListNode rightSide = prevMiddleNode.next;
		prevMiddleNode.next = null;
		leftSide = sortListHelper(leftSide);
		rightSide = sortListHelper(rightSide);
		return mergeList(leftSide,rightSide);
		
		
	}
	
	public ListNode findMiddleNode(ListNode head) {
		ListNode slowNode = head;
		ListNode fastNode = head;
		ListNode prevSlowNode = null;
		while(fastNode != null) {
			fastNode = fastNode.next;
			prevSlowNode = slowNode;
			slowNode = slowNode.next;
			if(fastNode != null) {
				fastNode = fastNode.next;
			}
		}
		return prevSlowNode;
	}
	
	public ListNode mergeList(ListNode left, ListNode right) {
		if(left == null && right == null) {
			return null;
		}else if(left == null) {
			return right;
		}else if(right == null) {
			return left;
		}else {
			ListNode temp;
			if(left.val < right.val) {
				temp = left;
				temp.next = mergeList(left.next,right);
				return temp;
			}else {
				temp = right;
				temp.next = mergeList(left,right.next);
				return temp;
			}
		}	
	}
	
	public static void main(String[] args) {
		SortList temp = new SortList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		temp.sortList(head);
	}

}
