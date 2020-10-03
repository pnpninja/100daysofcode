package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

public class CoinChange {
	
	public static int coinChange(int[] coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		
		
        Arrays.sort(coins);
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for(int i = 0; i<= amount; i++) {
        	for(int coin : coins) {
        		if(i >= coin) {
        			dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        		}
        	}
        }
        return dp[amount] > amount ? -1 : dp[amount];
       
   
         
    }
	
	public static void main(String[] args) {
		int[] temp = new int[] {1,5,6,8};
		System.out.println(coinChange(temp, 11));
	}

}
