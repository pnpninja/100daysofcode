package edu.stonybrook.pnarendra.medium;

public class TwoSumII {
	
	public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
        	if(target < numbers[left] + numbers[right]) {
        		right--;
        	}else if(target > numbers[left] + numbers[right]) {
        		left++;
        	}else {
        		return new int[] {left+1,right+1};
        	}
        }
        return new int[] {-1,-1};
    }

}
