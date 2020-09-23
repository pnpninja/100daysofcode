package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length && diff > 0; i++) {
        	int low = i + 1, high = len - 1;
        	while(low < high) {
        		int sum = nums[i] + nums[low] + nums[high];
            	if(Math.abs(target - sum) < Math.abs(diff)) {
            		diff = Math.abs(target - sum);
            	}
            	if(sum < target) {
            		++low;
            	}else {
            		--high;
            	}
        	}
        	
        }
        return target - diff;
    }

}
