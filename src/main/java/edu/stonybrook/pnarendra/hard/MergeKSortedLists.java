package edu.stonybrook.pnarendra.hard;

import edu.stonybrook.pnarendra.data_structures.ListNode;

// 23
// Merge k Sorted Lists
public class MergeKSortedLists {
	
	public ListNode mergeKLists(ListNode[] lists) {
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
