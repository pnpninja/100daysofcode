package edu.stonybrook.pnarendra.easy;

public class CheckIfNumberIsMajorityElementInASortedArray {
	
	public boolean isMajorityElement(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return false;
        }
        
        int first = binarySearchFirstIndex(nums,target);
        if(first == -1) {
        	return false;
        }
        int last = first + nums.length/2;
        return (last >= nums.length || nums[last] != target) ? false : true;
    }
	
	private int binarySearchFirstIndex(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		int low = 0;
		int high = nums.length - 1;
		while(low < high) {
			int mid = low + (high-low)/2;
			if(nums[mid] >= target) {
				high = mid;
			}else {
				low = mid + 1;
			}
		}
		
		return nums[low] == target ? low : -1;
	}

}
