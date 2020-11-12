package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;
import java.util.Comparator;

class Rock2{
	int weight;
	int value;
	
	public Rock2(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
}
public class KnapsackProblemUnbounded {
	
	static int unboundedKnapsack(int W, int n, int val[], int wt[]) {
		Rock2[] rocks = new Rock2[n];
		for(int i = 0; i < n; i++) {
			rocks[i] = new Rock2(wt[i],val[i]);
		}
		Arrays.sort(rocks, new Comparator<Rock2>() {
			@Override
			public int compare(Rock2 o1, Rock2 o2) {
				return new Integer(o1.weight).compareTo(o2.weight);
			}
			
		});
		int[] dp = new int[W + 1];
		dp[0] = 0;
		for(int i = 1; i <= W; i++) {
			for(int j = 0; j < n; j++) {
				if(rocks[j].weight <= i) {
					dp[i] = Math.max(dp[i], rocks[j].value + dp[i - rocks[j].weight]);
				}
			}
		}
		return dp[W];
	}
	
	public static void main(String[] args) {
		 int W = 100;
		 int val[] = {10, 30, 20};
		 int wt[] = {5, 10, 15};
		 int n = 3;
		 unboundedKnapsack(W, n, val, wt);
	}

}
