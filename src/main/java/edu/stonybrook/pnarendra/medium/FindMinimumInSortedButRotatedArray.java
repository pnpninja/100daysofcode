package edu.stonybrook.pnarendra.medium;

public class FindMinimumInSortedButRotatedArray {
	
	public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }
	
	private int findMinHelper(int[] nums, int start, int end) {
		if(start == end) {
			return nums[start];
		}else if(start + 1 == end) {
			return Math.min(nums[start], nums[end]);
		}else {
			int mid = (start+end)/2;
			if(nums[mid] < nums[end]) {
				return findMinHelper(nums, start, mid);
			}else {
				return findMinHelper(nums, mid, end);
			}
		}
	}
	
	

}
