package edu.stonybrook.pnarendra.dp;

import java.util.HashMap;
import java.util.Map;

public class RodCuttingProblem {
	Map<Integer,Integer> lengthToMaxValue;
	int cutRodWithMap(int price[]) {
		lengthToMaxValue = new HashMap<Integer, Integer>();
		lengthToMaxValue.put(0, 0);
		lengthToMaxValue.put(1, price[0]);
		return cutRodHelper(price,price.length);
	}
	
	int cutRodHelper(int price[], int len) {
		if(lengthToMaxValue.containsKey(len)) {
			return lengthToMaxValue.get(len);
		}else {
			int max = 0;
			for(int i = 0; i < len; i++) {
				max = Math.max(max,cutRodHelper(price,i) + price[len - i - 1]);
			}
			lengthToMaxValue.put(len, max);
			return lengthToMaxValue.get(len);
		}
	}
	
	static int cutRod(int[] price) {
		int[] dp = new int[price.length + 1];
		dp[0] = 0;
		dp[1] = price[0];
		
		for(int lenIdx = 2; lenIdx <= price.length; lenIdx++) {
			int max = 0;
			for(int i = 0; i < lenIdx; i++) {
				max = Math.max(max, dp[i] + price[lenIdx - i - 1]);
			}
			dp[lenIdx] = max;
		}
		return dp[price.length];
	}
	
	public static void main(String[] args) {
		RodCuttingProblem rcp = new RodCuttingProblem();
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(cutRod(price));
	}
}
