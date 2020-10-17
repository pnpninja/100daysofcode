package edu.stonybrook.pnarendra.medium;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
        	return s;
        }
        int start = 0,end = 0;
        for(int i = 0; i < s.length(); i++) {
        	int oddLength = middleExpansion(s,i,i);
        	int evenLength = middleExpansion(s,i,i+1);
        	int len = Math.max(oddLength, evenLength);
        	if(len > end - start) {
        		start = i- ((len - 1)/2);
        		end = i + (len/2);
        	}
        		
        }
        return s.substring(start,end+1);
    }
	private int middleExpansion(String s, int leftIndex, int rightIndex) {
    	if(s == null || leftIndex > rightIndex) {
    		return 0;
    	}
    	
    	while(leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
    		leftIndex--;
    		rightIndex++;
    	}
    	return rightIndex - leftIndex - 1;
    }

}
