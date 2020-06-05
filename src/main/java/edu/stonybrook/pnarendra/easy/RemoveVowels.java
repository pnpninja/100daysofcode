package edu.stonybrook.pnarendra.easy;

// 1119
// https://leetcode.com/problems/remove-vowels-from-a-string
public class RemoveVowels {
	public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}
