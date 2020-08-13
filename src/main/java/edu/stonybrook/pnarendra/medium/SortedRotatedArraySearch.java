package edu.stonybrook.pnarendra.medium;

// 33
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SortedRotatedArraySearch {
	
	public int search(int[] nums, int target) {
        if(nums.length == 0) {
        	return -1;
        }else {
        	return searchInSortedRotatedArray(nums, target, 0, nums.length - 1);
        }
    }
	
	public int searchInSortedRotatedArray(int[] nums, int target, int start, int end) {
		if(start == end) {
			if(nums[start] == target) {
				return start;
			}else {
				return -1;
			}
		}else if(start + 1 == end) {
			if(nums[start] == target) {
				return start;
			}else if(nums[end] == target) {
				return end;
			}else {
				return -1;
			}
		}else {
			int mid = (start + end)/2;
			if(nums[mid] == target) {
				return mid;
			}else {
				if(nums[start] < nums[mid]) {
					if(nums[start] <= target && target <= nums[mid]) {
						return searchInSortedRotatedArray(nums, target, start, mid);
					}else {
						return searchInSortedRotatedArray(nums, target, mid, end);
					}
				}else {
					if(nums[mid] <= target && target <= nums[end]) {
						return searchInSortedRotatedArray(nums, target, mid, end);
					}else {
						return searchInSortedRotatedArray(nums, target, start, mid);
					}
				}
			}
			
		}
	}

}
