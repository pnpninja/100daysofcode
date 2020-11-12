
package edu.stonybrook.pnarendra.dp;

public class PalindromePartitioning {
	
	public int numberOfSplits(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int[][] partitions = new int[s.length()][s.length()];
		for(int len = 1; len <= s.length(); len++) {
			int startIndex = 0;
			int endIndex = startIndex + len -1;
			if(len == 1) {
				while(endIndex < s.length()) {
					isPalindrome[startIndex][endIndex] = true;
					partitions[startIndex][endIndex] = 0;
					startIndex++;
					endIndex++;
				}		
			}else if(len == 2) {
				while(endIndex < s.length()) {
					if(s.charAt(startIndex) == s.charAt(endIndex)) {
						isPalindrome[startIndex][endIndex] = true;
						partitions[startIndex][endIndex] = 0;
					}else {
						isPalindrome[startIndex][endIndex] = false;
						partitions[startIndex][endIndex] = 1;
					}
					startIndex++;
					endIndex++;
				}
			}else {
				while(endIndex < s.length()) {
					if(s.charAt(startIndex) == s.charAt(endIndex) && isPalindrome[startIndex + 1][endIndex - 1] == true) {
						isPalindrome[startIndex][endIndex] = true;
						partitions[startIndex][endIndex] = 0;
					}else {
						isPalindrome[startIndex][endIndex] = false;
						int min = Integer.MAX_VALUE;
						for(int k = startIndex; k < endIndex; k++) {
							min = Math.min(min, partitions[startIndex][k]+partitions[k+1][endIndex] + 1);
						}
						partitions[startIndex][endIndex] = min;
					}
					startIndex++;
					endIndex++;
				}
			}
		}
		return partitions[0][s.length() - 1];
		
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().numberOfSplits("abcbm"));
	}

}
