package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.ListNode;

public class ConvertBinaryNumberInLinkedListToInteger {
	public int getDecimalValue(ListNode head) {
        int answer = 0;
        ListNode headIter = head;
        while(headIter != null) {
        	answer = (answer*2)+headIter.val;
        	headIter = headIter.next;
        }
        return answer;
    }
}
