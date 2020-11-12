package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.ListNode;
import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class ConvertSortedListToBinaryTree {
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
        	return null;
        }
        
        if(head.next == null) {
        	TreeNode temp = new TreeNode(head.val);
        	return temp;
        }
        
        if(head.next.next == null) {
        	TreeNode temp = new TreeNode(head.val);
        	temp.right = new TreeNode(head.next.val);
        	return temp;
        }
        
        ListNode leftSide = head;
		ListNode prevMiddleNode = findMiddleNode(head);
		ListNode middleNode = prevMiddleNode.next;
		ListNode rightSide = middleNode.next;
		prevMiddleNode.next = null;
		middleNode.next = null;
		TreeNode temp = new TreeNode(middleNode.val);
		temp.right = sortedListToBST(rightSide);
		temp.left = sortedListToBST(leftSide);
		return temp;
		
    }
	
	public ListNode findMiddleNode(ListNode head) {
		ListNode slowNode = head;
		ListNode fastNode = head.next;
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
	
	public static void main(String[] args) {
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
//		head.next.next.next.next.next = new ListNode(6);
		TreeNode mid = new ConvertSortedListToBinaryTree().sortedListToBST(head);
		System.out.println(mid.val);
	}

}
