package edu.stonybrook.pnarendra.medium;

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
};

public class LinkedListFlatten {

	public Node flatten(Node head) {
		if(head == null) return head;
		Node prevHead = new Node();
		prevHead.prev = null;
		prevHead.next = head;
		prevHead.child = null;
		flattenDFS(prevHead,head);
		prevHead.next.prev = null;
		return prevHead.next;		
	}

	public Node flattenDFS(Node prev, Node curr) {
		if (curr == null)
			return prev;
		curr.prev = prev;
		prev.next = curr;

		Node tempNext = curr.next;
		Node tail = flattenDFS(curr, curr.child);
		curr.child = null;
		return flattenDFS(tail, tempNext);
	}

}
