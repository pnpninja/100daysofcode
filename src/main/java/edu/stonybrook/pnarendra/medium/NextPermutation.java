package edu.stonybrook.pnarendra.medium;

public class NextPermutation {
	
	public void nextPermutation(int[] nums) {
        //Find first decreasing element
		int i = nums.length - 2;
		while(i >= 0 && nums[i]>=nums[i+1]) {
			i--;
		}
		int j;
		if(i>=0) {
			j = nums.length-1;
			while(j>=0 && nums[j]<=nums[i]) {
				j--;
			}
			//swap i and j 
			//reverse from i+1
			nums[i] = nums[i]+nums[j];
			nums[j] = nums[i] - nums[j];
			nums[i] = nums[i] - nums[j];

		}
		j = nums.length-1;
		i = i+1;
		while(i < j) {
			nums[i] = nums[i]+nums[j];
			nums[j] = nums[i] - nums[j];
			nums[i] = nums[i] - nums[j];
			i++;
			j--;
		}
			
    }

}
