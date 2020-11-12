package edu.stonybrook.pnarendra.dp;

public class LongestPalindromicSubsequence {
	
	static int longestPalindromicSubsequence(String str) {
		int[][] dp = new int[str.length()][str.length()];
		for(int level = 1; level <= str.length(); level++) {
			for(int rowIdx = 0; rowIdx <= str.length() - level;rowIdx++) {
				int colIdx = rowIdx + level - 1;
				if(level == 1) {
					dp[rowIdx][colIdx] = 1;
				}
				else if(level == 2) {
					if(str.charAt(rowIdx) == str.charAt(colIdx)) {
						dp[rowIdx][colIdx] = 2;
					}else {
						dp[rowIdx][colIdx] = 1;
					}
				}else {
					if(str.charAt(rowIdx) == str.charAt(colIdx)) {
						dp[rowIdx][colIdx] = 2 + dp[rowIdx + 1][colIdx - 1];
					}else {
						dp[rowIdx][colIdx] = Math.max(dp[rowIdx][colIdx - 1], dp[rowIdx + 1][colIdx]);
					}
				}
			}
		}
		return dp[0][str.length() - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindromicSubsequence("abba"));
	}

}
