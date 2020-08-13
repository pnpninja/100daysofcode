package edu.stonybrook.pnarendra.medium;

// 34
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstLastElementSortedArray {
	public int[] searchRange(int[] nums, int target) {
		if(nums.length == 0) {
			return new int[] {-1, -1};
		}if(nums.length == 1) {
			if(nums[0] == target) {
				return new int[] {0,0};
			}else {
				return new int[] {-1,-1};
			}
		}
        int locStart = binarySearchFirstOccurence(nums,target,0,nums.length - 1);
        int locEnd = binarySearchLastOccurence(nums,target,0,nums.length - 1);
        return new int[] {locStart, locEnd};
    }
	
	public int binarySearchFirstOccurence(int[] nums, int target, int start, int end) {
		if(start == end) {
			if(nums[start] == target) {
				return start;
			}else {
				return -1;
			}
		}else if(start + 1 == end){
			if(nums[start] == target) {
				return start;
			}else if(nums[end] == target) {
				return end;
			}else {
				return -1;
			}
		}else {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				if(mid == 0) {
					return mid;
				}else {
					return binarySearchFirstOccurence(nums, target, start, mid);
				}
			}else if(nums[mid] > target) {
				return binarySearchFirstOccurence(nums, target, start, mid - 1);
			}else {
				return binarySearchFirstOccurence(nums, target, mid + 1, end);
			}
			
		}
	}
	
	public int binarySearchLastOccurence(int[] nums, int target, int start, int end) {
		if(start == end) {
			if(nums[start] == target) {
				return start;
			}else {
				return -1;
			}
		}else if(start + 1 == end){
			if(nums[end] == target) {
				return end;
			}else if(nums[start] == target) {
				return start;
			}else {
				return -1;
			}
		}else {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				if(mid == nums.length) {
					return mid;
				}else {
					return binarySearchLastOccurence(nums, target, mid, end);
				}
			}else if(nums[mid] > target) {
				return binarySearchLastOccurence(nums, target, start, mid - 1);
			}else {
				return binarySearchLastOccurence(nums, target, mid + 1, end);
			}
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new FirstLastElementSortedArray().binarySearchLastOccurence(new int[]{5,7,7,8,8,10}, 8, 0, 5));
	}
	
	
}
