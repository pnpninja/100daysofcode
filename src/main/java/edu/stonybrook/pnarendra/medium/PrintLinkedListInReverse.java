package edu.stonybrook.pnarendra.medium;
import edu.stonybrook.pnarendra.data_structures.ImmutableListNode;


/// 1265
/// Link - https://leetcode.com/problems/print-immutable-linked-list-in-reverse/submissions/
public class PrintLinkedListInReverse {
	public void printLinkedListInReverse(ImmutableListNode head) {
        if(head.getNext() == null) {
        	head.printValue();
        }else {
        	printLinkedListInReverse(head.getNext());
        	head.printValue();
        }
    }
}
