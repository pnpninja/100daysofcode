package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
        rotateArray(nums,0,nums.length-1);
        rotateArray(nums,0,k-1);
        rotateArray(nums,k,nums.length-1);
        
    }
	
	public void rotateArray(int[] nums, int i, int j) {
		while (i < j) {
		      int temp = nums[i];
		      nums[i] = nums[j];
		      nums[j] = temp;
		      i++;
		      j--;
		    }
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		new RotateArray().rotate(nums,k);
	}

}
