package edu.stonybrook.pnarendra.medium;

public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
		int ind = 1;
		boolean secondEntry = true;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] != nums[i-1]) {
        		nums[ind++]=nums[i];
        		secondEntry = true;
        	}else if(nums[i] == nums[i-1] && secondEntry) {
        		nums[ind++]=nums[i];
        		secondEntry = false;
        	}else {
        		secondEntry = false;
        		continue;
        	}
        }
        return ind;
    }
}
