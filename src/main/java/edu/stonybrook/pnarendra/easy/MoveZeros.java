package edu.stonybrook.pnarendra.easy;

// 283
// https://leetcode.com/problems/move-zeroes/
public class MoveZeros {
	
	public void moveZeroes(int[] nums) {
        int ptr = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != 0) {
        		nums[ptr] = nums[i];
        		ptr++;
        	}
        }
        
        while(ptr < nums.length) {
        	nums[ptr] = 0;
        	ptr++;
        }
    }

}
