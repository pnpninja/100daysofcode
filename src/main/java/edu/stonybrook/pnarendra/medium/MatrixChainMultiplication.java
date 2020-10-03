package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixChainMultiplication {
	
	public static void printMatrix(int[][] mat) {
		int len = mat.length + 1;
		for(int iter = 1; iter < len - 1; iter++) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int row = 0; row < len -1 - iter; row++) {
				int col = row + iter;
				temp.add(mat[row][col]);
			}
			System.out.println(Arrays.deepToString(temp.toArray()));
		}
		
	}
	
	public static int matrixChainMultiplication(int[] arr) {
		int len = arr.length;
		int[][] matrix = new int[arr.length - 1][arr.length - 1];
		
		//Set default values
		for(int i = 0, j = 0; i < matrix.length && j < matrix.length; i++,j++) {
			matrix[i][j] = 0;
		}
		
		//Lets Iterate and Start to fill
		for(int iter = 1; iter < len - 1; iter++) {
			for(int row = 0; row < len - 1 - iter; row++) {
				int col = row + iter;
				int min = Integer.MAX_VALUE;
				matrix[row][col] = minMultiply(matrix, arr, row, col);
			}
		}
		return matrix[0][arr.length - 2];
	}
	
	private static int minMultiply(int[][] matrix, int[] arr, int row, int col) {
		int iter = col - row;
		int ans = Integer.MAX_VALUE;
		for(int i = row; i < col; i++) {
			ans = Math.min(ans, matrix[row][i] + matrix[i + 1][col] 
					+ arr[row]*arr[i + 1]*arr[col + 1]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {10, 20, 30};
		matrixChainMultiplication(arr);
	}

}
