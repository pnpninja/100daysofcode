package edu.stonybrook.pnarendra.easy;

import java.util.Arrays;

public class TwoSumLessThanK {
	
	public int twoSumLessThanK(int[] A, int K) {
		int answer = -1;
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        while(left < right) {
        	if(A[left]+A[right] < K) {
        		answer = Math.max(answer, A[left]+A[right]);
        		left++;
        	}else {
        		right--;
        	}
        }
        return answer;
    }

}
