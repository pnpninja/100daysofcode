package edu.stonybrook.pnarendra.dp;

public class PalindromicSubsequenceCount {
	
	static int countPalindromicSubsequence(String str) {
		int[][] dp = new int[str.length()][str.length()];
		for(int level = 1; level <= str.length(); level++) {
			for(int rowIdx = 0; rowIdx <= str.length() - level;rowIdx++) {
				int colIdx = rowIdx + level - 1;
				if(level == 1) {
					dp[rowIdx][colIdx] = 1;
				}
				else if(level == 2) {
					if(str.charAt(rowIdx) == str.charAt(colIdx)) {
						dp[rowIdx][colIdx] = 3;
					}else {
						dp[rowIdx][colIdx] = 2;
					}
				}else {	
					if(str.charAt(rowIdx) == str.charAt(colIdx)) {
						dp[rowIdx][colIdx] = 1 + dp[rowIdx + 1][colIdx] + dp[rowIdx][colIdx - 1]; 
					}else{
						dp[rowIdx][colIdx] = dp[rowIdx + 1][colIdx] + dp[rowIdx][colIdx - 1] - dp[rowIdx + 1][colIdx - 1];
					}
				}
			}
		}
		return dp[0][str.length() - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(countPalindromicSubsequence("abcd"));
	}

}
