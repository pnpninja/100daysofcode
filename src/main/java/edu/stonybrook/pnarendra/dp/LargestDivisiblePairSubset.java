package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;

public class LargestDivisiblePairSubset {
	
	static int largestSubset(int[] a) {
		if(a == null || a.length == 0) {
			return 0;
		}
		Arrays.sort(a);
		int[] dp = new int[a.length];
		dp[a.length - 1] = 1;
		for(int idx = a.length-2; idx >= 0; idx--) {
			int max = 0;
			for(int j = idx + 1; j < a.length; j++) {
				if(a[j] % a[idx] == 0 || a[idx] % a[j] == 0) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[idx] = 1 + max;
		}
		return Arrays.stream(dp).max().getAsInt();
		
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 6, 13, 17, 18 };
		System.out.println(largestSubset(a));
	}

}
