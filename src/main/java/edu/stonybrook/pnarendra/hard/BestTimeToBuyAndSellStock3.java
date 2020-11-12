package edu.stonybrook.pnarendra.hard;

public class BestTimeToBuyAndSellStock3 {
	
	public int maxProfit(int[] price) {
		int[] profit = new int[price.length];
		int maxPrice = price[price.length - 1];
		for(int i = price.length - 2; i>= 0; i--) {
			if(maxPrice < price[i]) {
				maxPrice = price[i];
			}
			
			profit[i] = Math.max(profit[i + 1], maxPrice - price[i]);
		}
		int minPrice = price[0];
		for(int i = 1; i < price.length; i++) {
			if(minPrice > price[i]) {
				minPrice = price[i];
			}
			
			profit[i] = Math.max(profit[i - 1], profit[i] + price[i] - minPrice);
		}
		return profit[price.length - 1];
	}
	

}
