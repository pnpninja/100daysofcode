package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;

public class ModularSubsetSum {
	
	static boolean modularSum(int arr[], int m) {
		
		if(m == 0) {
			return true;
		}
		
		if(arr.length == 0) {
			return false;
		}
		
		Arrays.sort(arr);
		
		boolean[][] dp = new boolean[arr.length][m];
		for(int arrIdx = 0; arrIdx < arr.length; arrIdx++) {
			for(int moduloIdx = 0; moduloIdx < m; moduloIdx++) {
				if(arrIdx == 0) {
					int moduloIdxUnderstand = moduloIdx + 1;
					dp[arrIdx][moduloIdx] = arr[arrIdx] % moduloIdxUnderstand == 0? true : false;
				}else {
					int moduloIdxUnderstand = moduloIdx + 1;
					if(moduloIdxUnderstand == 1) {
						dp[arrIdx][moduloIdx] = true;
					}else if(moduloIdxUnderstand == arr[arrIdx]) {
						dp[arrIdx][moduloIdx] = true;
					}else {
						int remainder = arr[arrIdx] % moduloIdxUnderstand;
						if(remainder == 0) {
							dp[arrIdx][moduloIdx] = true;
						}else {
							dp[arrIdx][moduloIdx] = dp[arrIdx - 1][moduloIdxUnderstand - remainder - 1];
						}
						
					}
				}
				
			}
		}
		return dp[arr.length - 1][m];
	}
	
	public static void main(String[] args) {
		int arr[] = {1,7}; 
        int m = 5; 
      
        if(modularSum(arr, m)) 
            System.out.print("YES\n"); 
        else
            System.out.print("NO\n"); 
	}

}
