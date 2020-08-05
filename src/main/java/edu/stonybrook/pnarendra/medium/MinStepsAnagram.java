package edu.stonybrook.pnarendra.medium;

// 1347
// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
public class MinStepsAnagram {
	public int minSteps(String s, String t) {
       int[] sFreq = countFreq(s);
       int[] tFreq = countFreq(t);
       
       int add = 0;
       for(int i = 0; i < 26; i++) {
    	   if(tFreq[i] < sFreq[i]) {
    		   add += sFreq[i] - tFreq[i];
    	   }
       }
       return add;
       
    }
	
	private int[] countFreq(String str) {
		int[] count = new int[26];
		for(char c : str.toCharArray()) {
			count[c - 97]++;
		}
		return count;
	}
	

}
