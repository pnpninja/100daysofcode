package edu.stonybrook.pnarendra.hard;

public class RegularExpressionMatching {
	
	public boolean isMatch(String text, String pattern) {
        boolean[][]  dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp[0].length;i++) {
        	if(pattern.charAt(i - 1) == '*') {
        		dp[0][i] = dp[0][i-2];
        	}
        }
        
        for(int textIter = 1; textIter <= text.length(); textIter++) {
        	for(int patternIter = 1; patternIter <= pattern.length(); patternIter++) {
        		if(text.charAt(textIter - 1) == pattern.charAt(patternIter - 1) || pattern.charAt(patternIter - 1) == '.') {
        			dp[textIter][patternIter] = dp[textIter - 1][patternIter - 1];
        		}else if(pattern.charAt(patternIter - 1) == '*') {
        			dp[textIter][patternIter] = dp[textIter][patternIter - 2];
        			if(text.charAt(textIter - 1) == pattern.charAt(patternIter - 2) || pattern.charAt(patternIter - 2) == '.') {
        				dp[textIter][patternIter] = dp[textIter][patternIter] | dp[textIter - 1][patternIter];
        			}
        					
        		}else {
        			dp[textIter][patternIter] = false;
        		}
        	}
        }
        return dp[text.length()][pattern.length()];
        
    }
	

}
