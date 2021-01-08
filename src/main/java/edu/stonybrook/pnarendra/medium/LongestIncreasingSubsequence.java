package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int last = 0;
        int[] sorted = new int[n];
        for(int num : nums) {
        	int lowerBound = Arrays.binarySearch(sorted, 0,last,num);
        	if(lowerBound < 0) {
        		lowerBound = -lowerBound-1;
        	}
        	sorted[lowerBound] = num;
        	if(lowerBound == last) {
        		last++;
        	}
        }
        return last;
    }

}
