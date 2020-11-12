package edu.stonybrook.pnarendra.dp;

public class BuySellStocksKTimes {
	
	static int maxProfit(int price[], int k) {
		int[][] dp = new int[k + 1][price.length];
		for(int kIdx = 0; kIdx <= k; kIdx++) {
			for(int priceIdx = 0; priceIdx < price.length; priceIdx++) {
				if(kIdx == 0 || priceIdx == 0) {
					dp[kIdx][priceIdx] = 0;
				}else {
					int max = dp[kIdx][priceIdx - 1];
					for(int prevDayIdx = 0; prevDayIdx < priceIdx; prevDayIdx++) {
						max = Math.max(max, price[priceIdx] - price[prevDayIdx] + dp[kIdx - 1][prevDayIdx]);
					}
					dp[kIdx][priceIdx] = max;
				}
			}
		}
		return dp[k][price.length - 1];
	}
	
	public static void main(String[] args) {
		int k = 2;
		int[] price = { 10, 22, 5, 75, 65, 80};
		System.out.println(maxProfit(price, k));
	}

}
