package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

// 3
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringNonRepeatingCharacters {
		
	public int lengthOfLongestSubstring(String s) {
		
		Map<Character, Integer> charLastIndexMap = new HashMap<Character, Integer>();
		int left = 0;
		int right = 0;
		int len = 0;
		while(left <= right && right < s.length()) {
			if(!charLastIndexMap.containsKey(s.charAt(right))) {
				charLastIndexMap.put(s.charAt(right), right);
				len = Math.max(len, right-left+1);
				right++;
			}else {
				int moveLeftIndex = charLastIndexMap.get(s.charAt(right)) + 1;
				while(left < moveLeftIndex) {
					charLastIndexMap.remove(s.charAt(left));
					left++;
				}
				charLastIndexMap.put(s.charAt(right), right);
				len = Math.max(len, right-left+1);
				right++;
				
			}
		}
		return len;
	
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringNonRepeatingCharacters().lengthOfLongestSubstring(""));
	}

}
