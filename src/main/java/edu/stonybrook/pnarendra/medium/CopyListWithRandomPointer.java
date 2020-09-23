package edu.stonybrook.pnarendra.medium;


public class CopyListWithRandomPointer {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyRandomList(Node head) {
        head = createDuplicateNodesAdjacentToIt(head);
        linkRandomNodes(head);
        return removeDuplicateNodes(head);
    }
	
	private Node createDuplicateNodesAdjacentToIt(Node head) {
		if(head == null) {
			return null;
		}else if(head.next == null) {
			Node dup = new Node(head.val);
			dup.next = null;
			dup.random = null;
			head.next = dup;
			return head;
		}else {
			Node temp = head.next;
			Node dup = new Node(head.val);
			dup.next = temp;
			dup.random = null;
			head.next = dup;
			temp = createDuplicateNodesAdjacentToIt(temp);
			return head;
		}
	}
	
	private void linkRandomNodes(Node head) {
		Node iterator = head;
		while(iterator != null) {
			iterator.next.random = iterator.random == null ? null : iterator.random.next;
			iterator = iterator.next.next;
		}
	}
	
	private Node removeDuplicateNodes(Node head) {
		if(head == null) {
			return null;
		}else if(head.next.next == null) {
			Node temp = head.next;
			head.next = head.next.next;
			return temp;
		}else {
			Node t2 = removeDuplicateNodes(head.next.next);
			Node temp = head.next;
			head.next = head.next.next;
			temp.next = t2;
			return temp;
			
		}
	}
	
	
}
