package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.ListNode;

public class Oracle_PermutationsOfLinkedList {
	
	public List<ListNode> permutations(ListNode node){
		List<ListNode> answers = new ArrayList<ListNode>();
		List<ListNode> permutation = new ArrayList<ListNode>();
		int size = 0;
		ListNode temp = node;
		while(temp!=null) {
			size++;
			temp = temp.next;
		}
		backtrack(answers,permutation,node,size);
//		for(ListNode answer : answers) {
//			String temp2 = "";
//			while(answer != null) {
//				temp2 = temp2+" "+answer.val;
//				answer = answer.next;
//			}
//			System.out.println(temp2);
//		}
		return answers;
	}
	
	public void backtrack(List<ListNode> answers, List<ListNode> permutation, ListNode start, int size) {
		if(permutation.size() == size) {
			answers.add(prepareList(permutation));
			return;
		}
		
		if(permutation.size() == size - 1) {
			permutation.add(start);
			answers.add(prepareList(permutation));
			permutation.remove(permutation.size() - 1);
			return;
		}
		
		ListNode temp = start;
		temp = temp.next;
		permutation.add(start);
		backtrack(answers,permutation,temp,size);
		permutation.remove(permutation.size() - 1);
		
		ListNode x = start;
		ListNode prev = start;
		ListNode curr = start.next;
		while(curr != null) {
			prev.next = curr.next;
			permutation.add(curr);
			backtrack(answers,permutation,x,size);
			permutation.remove(permutation.size() - 1);
			prev.next = curr;
			prev = curr;
			curr = curr.next;
		}
		
	}
	
	public ListNode prepareList(List<ListNode> permutation) {
		ListNode newNode = null;
		ListNode start = null;
		for(ListNode node : permutation) {
			ListNode t = new ListNode(node.val);
			if(newNode == null) {
				newNode = t;
				start = t;
			}else {
				newNode.next = t;
				newNode = newNode.next;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		new Oracle_PermutationsOfLinkedList().permutations(node);
	}
}
