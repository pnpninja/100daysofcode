package edu.stonybrook.pnarendra.easy;

public class HouseRobber {

	public int rob(int[] nums) {
		Integer[] dp = new Integer[nums.length];
		return helper(nums, 0, dp);
	}

	public int helper(int[] nums, int index, Integer[] dp) {
		if (index >= nums.length) {
			return 0;
		}

		if (dp[index] != null) {
			return dp[index];
		}
		int choose1 = nums[index] + (helper(nums, index + 2, dp));
		int t = (index + 1 >= nums.length) ? 0 : nums[index + 1];
		int choose2 = t + (helper(nums, index + 3, dp));
		dp[index] = Math.max(choose1, choose2);
		return dp[index];

	}
}
