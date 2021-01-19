package edu.stonybrook.pnarendra.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class LongestContiguousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	
	public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int result = 1;
        int left = 0;
        for(int r = 0; r < nums.length; r++) {
        	while(!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
        		maxDeque.removeLast();
        	}
        	maxDeque.addLast(nums[r]);
        	
        	while(!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
        		minDeque.removeLast();
        	}
        	minDeque.addLast(nums[r]);
        	
        	while(maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
        		if(maxDeque.peekFirst() == nums[left]) {
        			maxDeque.pollFirst();
        		}
        		if(minDeque.peekFirst() == nums[left]) {
        			minDeque.pollFirst();
        		}
        		++left;
        	}
        	result = Math.max(result, r - left + 1); 
        }
        return result;
    }

}
