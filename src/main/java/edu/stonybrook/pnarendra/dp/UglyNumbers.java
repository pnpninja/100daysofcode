package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;

public class UglyNumbers {

	static int[] getNUglyNumbers(int N) {
		int iter2 = 0, iter3 = 0, iter5 = 0;
		int nextMultiple2 = 2, nextMultiple3 = 3, nextMultiple5 = 5;
		
		int[] uglyNumbers = new int[N];
		uglyNumbers[0] = 1;
		for(int i = 1; i < N; i++) {
			int min = Math.min(nextMultiple2, Math.min(nextMultiple3, nextMultiple5));
			uglyNumbers[i] = min;
			
			if(min == nextMultiple2) {
				iter2++;
				nextMultiple2 = uglyNumbers[iter2]*2;
			}
			
			if(min == nextMultiple3) {
				iter3++;
				nextMultiple3 = uglyNumbers[iter3]*2;
			}
			
			if(min == nextMultiple5) {
				iter5++;
				nextMultiple5 = uglyNumbers[iter5]*2;
			}
		}
		return uglyNumbers;
	}
	
	public static void main(String[] args) {
		int N = 13;
		int[] ans = getNUglyNumbers(N);
		System.out.println(Arrays.toString(ans));
	}
}
