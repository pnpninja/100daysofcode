package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;
import java.util.Comparator;

class Rock{
	int weight;
	int value;
	
	public Rock(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
}
public class KnapsackProblem01 {
	
	static int knapSack(int W, int wt[], int val[], int n) {
		Rock[] rocks = new Rock[n];
		for(int i = 0; i < n; i++) {
			rocks[i] = new Rock(wt[i],val[i]);
		}
		Arrays.sort(rocks, new Comparator<Rock>() {
			@Override
			public int compare(Rock o1, Rock o2) {
				return new Integer(o1.weight).compareTo(o2.weight);
			}
			
		});
		int[][] dp = new int[n][W + 1];
		for(int col = 1; col <= W; col++) {
			if(rocks[0].weight > col) {
				dp[0][col] = 0;
			}else {
				dp[0][col] = rocks[0].value;
			}
		}
		
		for(int row = 1; row < n; row++) {
			for(int col = 1; col <= W; col++) {
				if(rocks[row].weight > col) {
					dp[row][col] = dp[row - 1][col];
				}else {
					dp[row][col] = Math.max(dp[row - 1][col], rocks[row].value + dp[row - 1][col - rocks[row].weight]);
				}
			}
		}
		return dp[n-1][W];
	}
	
	public static void main(String[] args) {
		int[] wt = {2,3,1,2};
		int[] val = {3,4,1,3};
		int W =5;
		int n = 4;
		System.out.println(knapSack(W, wt, val, n));

	}

}
