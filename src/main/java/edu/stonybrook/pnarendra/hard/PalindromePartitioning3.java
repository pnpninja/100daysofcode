package edu.stonybrook.pnarendra.hard;

import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioning3 {
	Map<String, Integer> dp = new HashMap<String, Integer>();
	public int palindromePartition(String s, int k) {
        String key = s+","+k;
        if(dp.containsKey(key)) {
        	return dp.get(key);
        }
        
        if(k == 1) {
        	int c = 0;
        	for(int i = 0; i < s.length()/2;i++) {
        		if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        			c++;
        		}
        	}
        	dp.put(key, c);
        	return c;
        }
        int output = Integer.MAX_VALUE;
        for(int kIter = 1; kIter < k; kIter++) {
        	for(int i = 1; i <= s.length() - (k - kIter);i++) {
        		if(i>=kIter) {
        			int left = palindromePartition(s.substring(0, i),kIter);
        			int right = palindromePartition(s.substring(i),k - kIter);
        			output = Math.min(output,left+right);
        		}else {
        			break;
        		}
        	}
        }
        dp.put(key, output);
        return output;
    }

}
