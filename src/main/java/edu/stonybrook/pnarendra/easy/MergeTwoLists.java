package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.ListNode;

// 21
// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode[] arr = new ListNode[2];
        arr[0] = l1;
        arr[1] = l2;
        return mergeKLists(arr);
    }
	
	private ListNode mergeKLists(ListNode[] lists) {
        boolean isAllNull = true;
        int minLoc = -1;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < lists.length; i++) {
        	if(lists[i] != null) {
        		isAllNull = false;
        		if(lists[i].val < min) {
        			min = lists[i].val;
        			minLoc = i;
        		}
        	}
        }
        
        if (isAllNull) {
        	return null;
        }else {
        	ListNode temp = lists[minLoc];
        	lists[minLoc] = lists[minLoc].next;
        	temp.next = mergeKLists(lists);
        	return temp;
        }
    }

}
