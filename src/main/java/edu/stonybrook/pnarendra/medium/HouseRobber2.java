package edu.stonybrook.pnarendra.medium;

public class HouseRobber2 {
	public int rob(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
        Integer[] dp1 = new Integer[nums.length];
        Integer[] dp2 = new Integer[nums.length];
        return Math.max(robHelper(nums,dp1,0,nums.length-2),robHelper(nums,dp2,1,nums.length-1));
    }
	
	public int robHelper(int[] nums, Integer [] dp, int idx, int end) {
		if(idx > end) {
			return 0;
		}
		if(dp[idx] != null) {
			return dp[idx];
		}
		
		int choose1 = nums[idx] + robHelper(nums,dp,idx + 2,end);
		int t = idx + 1 > end ? 0 : nums[idx + 1];
		int choose2 = t + robHelper(nums,dp,idx+3,end);
		dp[idx]= Math.max(choose1, choose2);
		return dp[idx];
	}
}
