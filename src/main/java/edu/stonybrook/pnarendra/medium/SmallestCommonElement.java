package edu.stonybrook.pnarendra.medium;

public class SmallestCommonElement {

	private boolean binarySearch(int[] nums, int target, int start, int end) {
		if(start == end) {
			if(nums[start] == target) {
				return true;
			}else {
				return false;
			}
		}else if(target < nums[start] || target > nums[end]) {
			return false;
		}else if(target == nums[start] || target == nums[end]) {
			return true;
		}else {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				return true;
			}else if(nums[mid] > target) {
				return binarySearch(nums, target, start, mid);
			}else {
				return binarySearch(nums, target, mid + 1, end);
			}
		}
	}
	public int smallestCommonElement(int[][] mat) {
       for(int i = 0; i < mat[0].length; i++) {
    	   boolean found = true;
    	   for(int j = 1; j < mat.length; j++) {
    		   if(!binarySearch(mat[j], mat[0][i], 0, mat[0].length - 1)) {
    			   found = false;
    			   break;
    		   }
    	   }
    	   if(found) {
    		   return mat[0][i];
    	   }
    	   
       }
       return -1;
    }
	
	
}
