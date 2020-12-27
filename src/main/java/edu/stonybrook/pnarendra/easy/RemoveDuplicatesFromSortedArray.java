package edu.stonybrook.pnarendra.easy;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int ind = 1;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] != nums[i-1]) {
        		nums[ind++]=nums[i];
        	}else {
        		continue;
        	}
        }
        return ind;
    }
}
