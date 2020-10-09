package edu.stonybrook.pnarendra.medium;

public class PaintHouse {
	public int minCost(int[][] costs) {
		if(costs.length == 0) {
			return 0;
		}
		int houses = costs.length;
		int colors = costs[0].length;
		int[][] dp = new int[colors][houses];
		for(int house = 0; house < houses; house++) {
			for(int color = 0; color < colors; color++) {
				if(house == 0) {
					dp[color][house] = costs[house][color];
				}else {
					dp[color][house] = Integer.MAX_VALUE;
					int prevHouse = house - 1;
					for(int t = 0; t < colors; t++) {
						if(t == color) {
							continue;
						}else {
							dp[color][house] = Math.min(dp[color][house], costs[house][color]+dp[t][prevHouse]);
						}
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < colors;i++) {
			ans = Math.min(ans, dp[i][houses -1]);
		}
		return ans;
		
        
    }
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(new PaintHouse().minCost(arr));
	}
}
