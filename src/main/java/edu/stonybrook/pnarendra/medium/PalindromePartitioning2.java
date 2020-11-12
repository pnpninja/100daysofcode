package edu.stonybrook.pnarendra.medium;

public class PalindromePartitioning2 {
	
	public int minCut(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		for(int len = 1; len <= s.length(); len++) {
			int startIndex = 0;
			int endIndex = startIndex + len -1;
			if(len == 1) {
				while(endIndex < s.length()) {
					isPalindrome[startIndex][endIndex] = true;
					startIndex++;
					endIndex++;
				}		
			}else if(len == 2) {
				while(endIndex < s.length()) {
					if(s.charAt(startIndex) == s.charAt(endIndex)) {
						isPalindrome[startIndex][endIndex] = true;
					}else {
						isPalindrome[startIndex][endIndex] = false;
					}
					startIndex++;
					endIndex++;
				}
			}else {
				while(endIndex < s.length()) {
					if(s.charAt(startIndex) == s.charAt(endIndex) && isPalindrome[startIndex + 1][endIndex - 1] == true) {
						isPalindrome[startIndex][endIndex] = true;
					}else {
						isPalindrome[startIndex][endIndex] = false;	
					}
					startIndex++;
					endIndex++;
				}
			}
		}
		int[] minCut = new int[s.length()];
		minCut[0] = 0;
		for(int j = 1; j < s.length(); j++) {
			if(isPalindrome[0][j]) {
				minCut[j] = 0;
			}else {
				int min = Integer.MAX_VALUE;
				for(int i = 1; i <= j; i++) {
					if(isPalindrome[i][j] == true) {
						min = Math.min(min, minCut[i - 1] + 1);
					}
				}
				minCut[j] = min;
			}
		}
		return minCut[s.length() - 1];
	}

}
