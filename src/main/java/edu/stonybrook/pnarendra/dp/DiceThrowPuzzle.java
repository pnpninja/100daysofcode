package edu.stonybrook.pnarendra.dp;

public class DiceThrowPuzzle {

	static int diceThrow(int sum, int faces, int nosDices)
	{
		int[][] dp = new int[nosDices + 1][sum + 1];
		for(int i = 1; i<= sum; i++) {
			if(i <= faces) {
				dp[1][i] = 1;
			}
		}
		
		for(int nosDiceIter = 2; nosDiceIter <= nosDices; nosDiceIter++) {
			for(int sumIter = 1; sumIter <= sum; sumIter++) {
				for(int remainingSumIter = 1; remainingSumIter < sumIter && remainingSumIter <= faces; remainingSumIter++) {
					dp[nosDiceIter][sumIter] += dp[nosDiceIter - 1][sumIter - remainingSumIter];
				}
			}
		}
		return dp[nosDices][sum];
	}
	
	public static void main(String[] args) {
		System.out.println(diceThrow(8, 6, 3));
	}
}
