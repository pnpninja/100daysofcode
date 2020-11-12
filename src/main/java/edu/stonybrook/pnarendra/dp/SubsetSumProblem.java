package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;

public class SubsetSumProblem {
	
	static boolean isSubsetSum(int set[], int sum) {
		if(sum == 0) {
			return true;
		}
		
		if(set.length == 0) {
			return false;
		}
		Arrays.sort(set);
		boolean[][] dp = new boolean[set.length][sum + 1];
		for(int setIdx = 0; setIdx < set.length; setIdx++) {
			for(int sumIter = 0; sumIter <= sum; sumIter++ ) {
				if(sumIter == 0) {
					dp[setIdx][sumIter] = true;
				}else if(setIdx == 0) {
					if(set[setIdx] == sumIter) {
						dp[setIdx][sumIter] = true;
					}else {
						dp[setIdx][sumIter] = false;
					}
				}else {
					dp[setIdx][sumIter] = dp[setIdx - 1][sumIter];
					if(sumIter - set[setIdx] >= 0) {
						dp[setIdx][sumIter] = dp[setIdx][sumIter] || dp[setIdx - 1][sumIter - set[setIdx]];
					}
				}
			}
		}
		return dp[set.length - 1][sum];
		
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
