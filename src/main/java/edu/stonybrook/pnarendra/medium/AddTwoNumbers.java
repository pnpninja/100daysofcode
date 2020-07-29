package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.ListNode;

// 2
// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }
	
	private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carryOver) {
		if(l1 == null && l2 == null) {
			if(carryOver == 0) {
				return null;
			}else {
				ListNode temp = new ListNode(carryOver % 10);
				temp.next = addTwoNumbersHelper(l1,l2,carryOver/10);
				return temp;
			}
		}else if(l1 == null) {
			int sum = (l2.val + carryOver)%10;
			carryOver = (l2.val + carryOver)/10;
			ListNode temp = new ListNode(sum);
			temp.next = addTwoNumbersHelper(l1, l2.next,carryOver);
			return temp;
		}else if(l2 == null) {
			int sum = (l1.val + carryOver)%10;
			carryOver = (l1.val + carryOver)/10;
			ListNode temp = new ListNode(sum);
			temp.next = addTwoNumbersHelper(l1.next, l2,carryOver);
			return temp;
		}else {
			int sum = (l1.val + l2.val + carryOver)%10;
			carryOver = (l1.val + l2.val + carryOver)/10;
			ListNode temp = new ListNode(sum);
			temp.next = addTwoNumbersHelper(l1.next, l2.next,carryOver);
			return temp;
		}
	}

}
