package edu.stonybrook.pnarendra.medium;

public class MaximumProductSubarray {
	
	public int maxProduct(int[] nums) {
        if(nums.length == 0) {
        	return 0;
        }
        
        int min = nums[0],max = nums[0];
        int overallMax = nums[0];
        for(int i = 0; i < nums.length; i++) {
        	int temp = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
        	min =  Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
        	max = temp;
        	overallMax = Math.max(max, overallMax);
        }
        return overallMax;
        
    }

}
