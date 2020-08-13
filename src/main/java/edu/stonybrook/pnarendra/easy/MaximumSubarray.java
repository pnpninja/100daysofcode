package edu.stonybrook.pnarendra.easy;

// 53
// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
        	return 0;
        }
        
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
        	currentSum = Math.max(nums[i], currentSum + nums[i]);
        	maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

}
