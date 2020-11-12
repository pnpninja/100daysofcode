package edu.stonybrook.pnarendra.hard;

import java.util.Arrays;

public class MinimumDifficultyOfJobSchedule {
	
	public static int minDifficulty(int[] jobDifficulty, int d) {
		if (jobDifficulty == null || jobDifficulty.length == 0) return 0;
        // There are not enough jobs to make "at least one task every day"
        if (jobDifficulty.length < d) return -1;

        //int n = jobDifficulty.length;

        int[][] dp = new int[d + 1][jobDifficulty.length + 1];
        // init
        for (int[] r: dp) Arrays.fill(r, 1000 * d);
        dp[0][0] = 0;  // The minimum difficulty on day 0 to get 0 job done is 0

        for (int day = 1; day <= d; day ++) {
            for (int j = day; jobDifficulty.length - j >= d - day; j++) {
			    int currMax = jobDifficulty[j - 1];
                for (int k = j - 1; k >= day - 1; k--) {
                    currMax = Math.max(jobDifficulty[k], currMax);  // jobDifficulty[k] means the job difficulty of (k + 1)th job, converted to be 0-index based
                    dp[day][j] = Math.min(dp[day][j], dp[day - 1][k] + currMax);
                }
            }
        }

        return dp[d][jobDifficulty.length];
        
    }
	
	public static void main(String[] args) {
		int[] jobDifficulty = {7,1,7,1,7,1};
		int d = 3;
		minDifficulty(jobDifficulty, d);
	}

}
