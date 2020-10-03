package edu.stonybrook.pnarendra.hard;

public class FirstMissingPositive {
	
	public static int firstMissingPositive(int[] nums) {
		int len = nums.length;
        for(int i = 0; i < len; i++) {
        	if(nums[i] <= 0 || nums[i] > len) {
        		nums[i] = len + 1;
        	}
        }
        for(int i = 0; i < nums.length; i++) {
        	int temp = Math.abs(nums[i]);
        	if(temp <= len) {
        		nums[temp - 1] = -Math.abs(nums[temp - 1]);
        	}
        }
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] > 0) {
        		return i + 1;
        	}
        }
        return len + 1;
    }

	public static void main(String[] args) {
		int[] temp = new int[] {1,1};
		firstMissingPositive(temp);
	}
}
