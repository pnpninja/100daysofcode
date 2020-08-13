package edu.stonybrook.pnarendra.medium;

// 1143
// https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {
	
	public int longestCommonSubsequence(String text1, String text2) {
        int[][] matrix = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i <= text2.length(); i++) {
        	matrix[0][i] = 0;
        }
        
        for(int i = 0; i <= text1.length();i++) {
        	matrix[i][0] = 0;
        }
        
        for(int i = 1; i <= text1.length(); i++) {
        	for(int j = 1; j <= text2.length(); j++) {
        		if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
        			matrix[i][j] = matrix[i-1][j-1] + 1;
        		}else {
        			matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
        		}
        	}
        }
        
        return matrix[text1.length()][text2.length()];
        
    }

}
