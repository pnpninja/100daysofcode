package edu.stonybrook.pnarendra.medium;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		for(int num : nums) {
			product = product * num;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(product == 0) {
				nums[i] = 0;
			}else {
				nums[i] = product / nums[i];
			}
			
		}
		
		return nums;
    }

}
