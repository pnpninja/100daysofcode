package edu.stonybrook.pnarendra.easy;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0;i < prices.length; i++) {
        	profit = Math.max(profit, prices[i] - min);
        	if(prices[i] < min) {
        		min = prices[i];
        	}
        }
        return profit;
    }
}
