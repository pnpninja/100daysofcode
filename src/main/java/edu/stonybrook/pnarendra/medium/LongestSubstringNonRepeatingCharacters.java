package edu.stonybrook.pnarendra.medium;

// 3
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringNonRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }	

}
