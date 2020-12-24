package edu.stonybrook.pnarendra.medium;

public class DecodeWays {
	
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++) {
        	if(s.charAt(i) != '0') {
        		memo[i] = memo[i] + memo[i-1];
        	}
        	
        	int lastTwoDigits = Integer.valueOf(s.substring(i - 2,i));
        	if(lastTwoDigits >= 10 && lastTwoDigits <= 26) {
        		memo[i] = memo[i] + memo[i - 2];
        	}
        }
        return memo[s.length()];																																																				
    }
	

}
