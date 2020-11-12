package edu.stonybrook.pnarendra.hard;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
	
ArrayDeque<Integer> deque;
	
	public void cleanDeque(int i, int k, int[] nums) {
		if(!this.deque.isEmpty() && this.deque.getFirst() == i - k) {
			this.deque.removeFirst();
		}
		
		while(!this.deque.isEmpty() && nums[i] > nums[this.deque.getLast()]) {
			this.deque.removeLast();
		}
	}
	public int[] maxSlidingWindow(int[] nums, int k) {
        this.deque = new ArrayDeque<Integer>();
        int maxIdx = 0;
        for(int i = 0; i < k; i++) {
        	cleanDeque(i,k,nums);
        	this.deque.addLast(i);
        	if(nums[i] > nums[maxIdx]) {
        		maxIdx = i;
        	}
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[maxIdx];
        for(int i = k; i < nums.length; i++) {
        	cleanDeque(i,k,nums);
        	this.deque.addLast(i);
        	ans[i-k+1]=nums[this.deque.getFirst()];
        }
        return ans;
    }
	
	

}
