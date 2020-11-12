package edu.stonybrook.pnarendra.dp;

public class PaintingFenceAlgorithm {
	
	static int countWaysToPaintFence(int fences, int colors) {
		int[] dp = new int[fences + 1];
		dp[0] = 0;
		dp[1] = colors;
		dp[2] = colors * colors;
		
		for(int i = 3; i <= fences; i++) {
			dp[i] = (colors - 1)*(dp[i - 1] + dp[i - 2]);
		}
		return dp[fences];
		
	}
	
	public static void main(String[] args) {
		int fences = 2;
		int colors = 4;
		System.out.println(countWaysToPaintFence(fences, colors));
	}

}
