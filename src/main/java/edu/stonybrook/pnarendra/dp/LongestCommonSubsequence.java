package edu.stonybrook.pnarendra.dp;

public class LongestCommonSubsequence {
	static int longestCommonSubsequence(String a, String b) {
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		for(int aIter = 1; aIter <= a.length(); aIter++) {
			for(int bIter = 1; bIter <= b.length(); bIter++) {
				dp[aIter][bIter] = a.charAt(aIter - 1) == b.charAt(bIter - 1) ? dp[aIter - 1][bIter - 1] + 1 : Math.max(dp[aIter - 1][bIter], dp[aIter][bIter - 1]); 
			}
		}
		return dp[a.length()][b.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("ABCDGHLQR", "AEDPHR"));
	}
}
