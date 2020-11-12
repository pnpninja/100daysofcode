package edu.stonybrook.pnarendra.medium;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	int maxProfit(int[] price) {
		if(price.length <= 1) {
			return 0;
		}
		
		if(price.length == 2 ) {
			if(price[1] > price[0]) {
				return price[1] - price[0];
			}else {
				return 0;
			}
			
		}
		
		int[][] dp = new int[price.length][2];
		dp[0][0] = 0;
		dp[0][1] = -price[0];
		dp[1][0] = Math.max(dp[0][0], dp[0][1] + price[1]);
		dp[1][1] = Math.max(dp[0][1], dp[0][0] - price[1]);
		
		for(int i = 2; i < price.length; i++) {
			dp[i][0] = Math.max(dp[i-1][1] + price[i], dp[i - 1][0]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - price[i]);
		}
		return Math.max(dp[price.length - 1][0],dp[price.length - 1][1]);
	}

}
