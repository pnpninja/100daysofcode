package edu.stonybrook.pnarendra.dp;

public class FriendPairingProblem {
	
	static int countFriendsPairings(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for(int i = 2; i < n; i++) {
			dp[i] = i*dp[i-2]+dp[i-1];
		}
		return dp[n-1];
		
	}
	
	public static void main(String[] args) {
		countFriendsPairings(10);
	}

}
