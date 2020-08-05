package edu.stonybrook.pnarendra.medium;

import java.util.HashSet;
import java.util.Set;

// 1079
// https://leetcode.com/problems/letter-tile-possibilities/

//TODO Revisit after backtracking
public class LetterTilePossibilities {

	private Set<String> numTilePossibilitiesHelper(String tiles, Set<String> uniqueStrings) {
		generateSubsets(uniqueStrings, "", tiles, 0);
		// System.out.println(uniqueStrings.toString());
		return uniqueStrings;
	}

	private void generateSubsets(Set<String> uniqueStrings, String passover, String input, int index) {
		if (index == input.length()) {
			if (!passover.isEmpty()) {
				uniqueStrings.add(passover);
			}
			return;
		} else {
			String dup = new String(passover);
			dup = dup + input.charAt(index);
			generateSubsets(uniqueStrings, passover, input, index + 1);
			generateSubsets(uniqueStrings, dup, input, index + 1);
		}
	}

	private void generateSubsequences(Set<String> uniqueStrings, String input, int leftIndex, int rightIndex) {
		if (leftIndex == rightIndex) {
			numTilePossibilitiesHelper(input, uniqueStrings);
		} else {
			for (int i = leftIndex; i <= rightIndex; i++) {
				input = swap(input, leftIndex, i);
				generateSubsequences(uniqueStrings, input, leftIndex + 1, rightIndex);
				input = swap(input, leftIndex, i);
			}
		}
	}

	public int numTilePossibilities(String input) {
		Set<String> uniqueStrings = new HashSet<String>();
		generateSubsequences(uniqueStrings, input, 0, input.length() - 1);
		return uniqueStrings.size();
	}

	private String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
