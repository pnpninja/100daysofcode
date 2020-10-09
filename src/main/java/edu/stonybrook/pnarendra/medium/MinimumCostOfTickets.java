package edu.stonybrook.pnarendra.medium;

public class MinimumCostOfTickets {
	
	public int mincostTickets(int[] days, int[] costs) {
		Integer[] dp = new Integer[days.length];
		return helper(days,costs,0,dp);
    }
	
	private int helper(int[] days, int[] costs, int index, Integer[] dp) {
		if(index >= days.length) {
			return 0;
		}
		
		if(dp[index] != null) {
			return dp[index];
		}
		int oneDayPass = helper(days, costs, index + 1, dp) + costs[0];
		int i;
		for(i = index; i < days.length; i++) {
			if(days[i] >= days[index] + 7) {
				break;
			}
		}
		int sevenDayPass = helper(days, costs, i, dp) + costs[1];
		for(i = index; i < days.length; i++) {
			if(days[i] >= days[index] + 30) {
				break;
			}
		}
		
		int thirtyDayPass = helper(days, costs, i, dp) + costs[2];
		
		dp[index] = Math.min(Math.min(oneDayPass, sevenDayPass), thirtyDayPass);
		return dp[index];
			
	}
	

}
