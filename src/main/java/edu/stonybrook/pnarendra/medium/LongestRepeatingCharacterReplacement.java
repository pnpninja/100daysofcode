package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	
	public int characterReplacement(String s, int k) {
       int[] charCount = new int[26];
       int windowStart = 0, windowEnd = 0;
       int maxCharCount = 0;
       int maxLen = 0;
       for(; windowEnd < s.length(); windowEnd++) {
    	   charCount[s.charAt(windowEnd)-'A']++;
    	   maxCharCount = Math.max(maxCharCount,charCount[s.charAt(windowEnd)-'A']);
    	   while(windowEnd - windowStart + 1 - maxCharCount > k) {
    		   charCount[s.charAt(windowStart)-'A']--;
    		   windowStart++;
    	   }
    	   maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
       }
       return maxLen;
    }
	
	public static void main(String[] args) {
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
	}

}
