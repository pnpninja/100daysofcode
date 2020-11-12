package edu.stonybrook.pnarendra.hard;

import java.util.Arrays;

public class JumpGame2 {
	
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i < nums.length - 1;i++) {
        	int maxIdx = Math.min(nums.length - 1,i + nums[i]);
        	for(int j = i + 1; j<= maxIdx; j++) {
        		dp[j] = Math.min(dp[j], dp[i] + 1);
        	}
        }
        return dp[nums.length - 1];
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,0,1,4};
		System.out.println(new JumpGame2().jump(nums));
	}

}
