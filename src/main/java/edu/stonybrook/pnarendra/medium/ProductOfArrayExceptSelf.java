package edu.stonybrook.pnarendra.medium;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] answer = new int[nums.length];
		answer[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			answer[i] = answer[i-1]*nums[i-1];
		}
		 int R = 1;
	        for (int i = nums.length - 1; i >= 0; i--) {

	            // For the index 'i', R would contain the 
	            // product of all elements to the right. We update R accordingly
	            answer[i] = answer[i] * R;
	            R *= nums[i];
	        }
		return answer;
    }

}
