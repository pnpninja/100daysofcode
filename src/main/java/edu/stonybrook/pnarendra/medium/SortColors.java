package edu.stonybrook.pnarendra.medium;

public class SortColors {
	
	public static void sortColors(int[] nums) {
        //Get non 2s to left
		int i = 0;
		for(int idx = 0; idx < nums.length; idx++) {
			if(nums[idx] != 2) {
				nums[i++] = nums[idx];
			}
		}
		while(i < nums.length) {
			nums[i++] = 2;
		}
		
		//Get non 0s to the right
		i = nums.length-1;
		for(int idx = nums.length - 1; idx >= 0; idx--) {
			if(nums[idx] != 0) {
				nums[i--] = nums[idx];
			}
		}
		
		while(i >= 0) {
			nums[i--] = 0;
		}
		
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,0,2,1,1,0};
		sortColors(arr);
		System.out.println(arr);
	}

}
