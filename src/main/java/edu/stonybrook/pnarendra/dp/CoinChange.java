package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;

public class CoinChange {
	public static int count( int S[], int m) {
		Arrays.sort(S);
		int[][] dp = new int[S.length][m + 1];
		
		for(int coinIdx = 0; coinIdx < S.length; coinIdx++) {
			for(int denomination = 0; denomination <= m; denomination++) {
				if(denomination == 0) {
					dp[coinIdx][denomination] = 0;
				}else if(coinIdx == 0){
					if(denomination % S[coinIdx] == 0) {
						dp[coinIdx][denomination] = 1;
					}else {
						dp[coinIdx][denomination] = -1;
					}
				}else {
					int remAfterUsingOneCoin = denomination - S[coinIdx];
					if(remAfterUsingOneCoin < 0) {
						dp[coinIdx][denomination] = dp[coinIdx - 1][denomination];
					}else if(remAfterUsingOneCoin == 0) {
						dp[coinIdx][denomination] = 1;
						dp[coinIdx][denomination] += dp[coinIdx - 1][denomination] == -1?0:dp[coinIdx - 1][denomination];
					}else {
						int top = dp[coinIdx - 1][denomination];
						int left = dp[coinIdx][remAfterUsingOneCoin];
						if(top == -1 && left == -1) {
							dp[coinIdx][denomination] = -1;
						}else if(top == -1) {
							dp[coinIdx][denomination] = left;
						}else if(left == -1) {
							dp[coinIdx][denomination] = top;
						}else {
							dp[coinIdx][denomination] = top + left;
						}
					}
				}
			}
		}
		return dp[S.length - 1][m];
	}
	
	public static void main(String[] args) {
		int[] arr= {2,3,5,6,7}; 
	    int m = 10; 
	    System.out.println(count(arr, m));
	}
}
