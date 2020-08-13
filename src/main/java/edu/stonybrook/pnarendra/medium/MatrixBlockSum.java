package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;
// 1314
// https://leetcode.com/problems/matrix-block-sum/

public class MatrixBlockSum {
	
	private int[][] precomputeSumMatrix(int[][] mat) {
        int precomputeMatrix[][] = new int[mat.length][mat[0].length];
        precomputeMatrix[0][0] = mat[0][0];
        
        for(int i = 1; i < mat[0].length; i++) {
        	precomputeMatrix[0][i] = precomputeMatrix[0][i - 1] + mat[0][i];
        }
        
        for(int i = 1; i < mat.length; i++) {
        	precomputeMatrix[i][0] = precomputeMatrix[i-1][0] + mat[i][0];
        }
        
        for(int i = 1; i < mat.length; i++) {
        	for(int j = 1; j < mat[0].length; j++) {
        		precomputeMatrix[i][j] = precomputeMatrix[i-1][j] + precomputeMatrix[i][j-1] - precomputeMatrix[i-1][j-1] + mat[i][j];
        	}
        }
        
        return precomputeMatrix;
    }
		
	public int[][] matrixBlockSum(int[][] mat, int K) {
		int M = mat.length, N = mat[0].length;
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int rowSum = 0;
            for (int j = 0; j < N; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + rowSum + mat[i][j];
                rowSum += mat[i][j];
            }
        }
        int[][] res = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = dp[Math.min(i + K + 1, M)][Math.min(j + K + 1, N)] - dp[Math.max(i - K, 0)][Math.min(j + K + 1, N)] - dp[Math.min(i + K + 1, M)][Math.max(j - K, 0)] + dp[Math.max(i - K, 0)][Math.max(j - K, 0)];
            }
        }
        return res;
    }
	

}
