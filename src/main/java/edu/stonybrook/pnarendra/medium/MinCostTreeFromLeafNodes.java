package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

public class MinCostTreeFromLeafNodes {
	
	class TempObject{
		public int product;
		public int maxNumber;
		public int sumNodes;
		
		public TempObject() {
			this.product = 0;
			this.maxNumber = 0;
			this.sumNodes = Integer.MAX_VALUE;
			
		}
		
		public String toString() {
			return "{product = "+product+", maxNumber = "+maxNumber+", sumNodes = "+sumNodes+"}";
		}
		
	}
	public int mctFromLeafValues(int[] arr) {
		TempObject[][] dp = new TempObject[arr.length][arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				dp[i][j] = new TempObject();
				if(i == j) {
					dp[i][i].product = arr[i];
					dp[i][i].maxNumber = arr[i];
					dp[i][i].sumNodes = arr[i];
				}
			}
		}

		
		for(int iter = 1; iter < arr.length; iter++) {
			for(int row = 0; row <= arr.length - 1 - iter; row++) {
				int col = row + iter;
				dp[row][col] = fillValue(dp, row, col);
			}
		}

		return dp[0][arr.length - 1].sumNodes - Arrays.stream(arr).sum();
    }
	
	private TempObject fillValue(TempObject[][] dp, int row, int col) {
		int product = Integer.MAX_VALUE, maxNumber = Integer.MIN_VALUE, sumNodes = Integer.MAX_VALUE, temp = 0;
		for(int i = row; i < col; i ++) {
			product = dp[row][i].maxNumber * dp[i+1][col].maxNumber;
			maxNumber = Math.max(dp[row][i].maxNumber, dp[i+1][col].maxNumber);
			temp = dp[row][i].sumNodes + dp[i + 1][col].sumNodes;
			temp += product;
			if(temp < sumNodes) {
				sumNodes = temp;
				dp[row][col].product = product;
				dp[row][col].maxNumber = maxNumber;
				dp[row][col].sumNodes = sumNodes;
			}
		}
		return dp[row][col];
	}
	
	public static void main(String[] args) {
		MinCostTreeFromLeafNodes x = new MinCostTreeFromLeafNodes();
		int[] arr = new int[] {2,4,8};
		System.out.println(x.mctFromLeafValues(arr));
	}
}
