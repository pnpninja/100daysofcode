package edu.stonybrook.pnarendra.hard;

import java.util.Arrays;

public class JumpGame2 {
		
	 public int jump(int[] nums) {
		 int n = nums.length;
		 if(n < 2) {
			 return 0;
		 }
		 int jumps = 1;
		 int maxPos = nums[0];
		 int maxIndex = nums[0];
		 
		 for(int i = 1; i < n; i++) {
			 if(maxPos < i) {
				 ++jumps;
				 maxPos = maxIndex;
			 }
			 maxIndex = Math.max(maxIndex, i+nums[i]);
		 }
		 return jumps;
	 }
	
	public static void main(String[] args) {
		int[] nums = {2,3,0,1,4};
		System.out.println(new JumpGame2().jump(nums));
	}

}
