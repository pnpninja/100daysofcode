package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;

public class SubsetSumProblem2 {
	
	//Same problem in O(sum) space
	static boolean isSubsetSum(int set[], int sum) {
		if(sum == 0) {
			return true;
		}
		
		if(set.length == 0) {
			return false;
		}
		
		Arrays.sort(set);
		
		boolean[][] dp = new boolean[2][sum + 1];
		for(int sumIter = 0; sumIter <= sum; sumIter++) {
			if(sumIter == 0 || set[0] == sumIter) {
				dp[0][sumIter] = true;
			}
		}
		
		for(int setIdx = 1; setIdx < set.length; setIdx++) {
			for(int sumIter = 0; sumIter <= sum; sumIter++) {
				if(sumIter == 0) {
					dp[1][sumIter] = true;
				}else if(sumIter < set[setIdx]) {
					dp[1][sumIter] = dp[0][sumIter];
				}else {
					dp[1][sumIter] = dp[0][sumIter] || dp[0][sumIter - set[setIdx]];
				}
			}
			dp[0] = dp[1];
		}
		
		return dp[1][sum];
		
		
	}
	
	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 }; 
        int sum = 9; 
        if (isSubsetSum(set, sum) == true) 
            System.out.println("Found a subset"
                               + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
	}

}
