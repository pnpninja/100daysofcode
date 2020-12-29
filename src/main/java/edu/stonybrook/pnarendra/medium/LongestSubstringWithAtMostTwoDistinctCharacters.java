package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;

class DS2 {
	HashMap<Character, Integer> map;

	public DS2() {
		this.map = new HashMap<Character, Integer>();
	}

	public void addChar(char c) {
		this.map.put(c, this.map.getOrDefault(c, 0) + 1);
	}

	public void removeChar(char c) {
		this.map.put(c, this.map.get(c) - 1);
		if (this.map.get(c) <= 0) {
			this.map.remove(c);
		}
	}

	public int nosUniqueChars() {
		return this.map.size();
	}
}

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		DS2 ds = new DS2();
		int leftIndex = 0;
		int rightIndex = 0;
		int len = 1;
		if (s.length() == 0) {
			return 0;
		}
		ds.addChar(s.charAt(0));
		while (leftIndex <= rightIndex && rightIndex < s.length()) {
			if (ds.nosUniqueChars() <= 2) {
				len = Math.max(len, rightIndex - leftIndex + 1);
				if (rightIndex + 1 == s.length()) {
					break;
				} else {
					ds.addChar(s.charAt(rightIndex + 1));
					rightIndex++;
				}
				
			} else {
				ds.removeChar(s.charAt(leftIndex));
				leftIndex++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(
				new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct(""));
	}

}
