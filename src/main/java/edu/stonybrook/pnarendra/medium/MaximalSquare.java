package edu.stonybrook.pnarendra.medium;

public class MaximalSquare {
	
	public int maximalSquare(char[][] matrix) {
		int cols = matrix.length == 0 ? 0 : matrix[0].length;
        int[][] dp = new int[matrix.length + 1][cols + 1];
        int maxSq = 0;  
        for(int row = 1; row <= matrix.length; row++) {
        	for(int col = 1; col <= cols; col++) {
        		if(matrix[row - 1][col - 1] == '1') {
        			dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
        			maxSq = Math.max(maxSq, dp[row][col]);
            	}
        		
        	}
        }
        return maxSq * maxSq;
    }

}
