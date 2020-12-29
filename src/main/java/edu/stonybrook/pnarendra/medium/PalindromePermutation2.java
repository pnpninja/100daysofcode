package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation2 {
	
	public List<String> generatePalindromes(String s) {
        //Calculate hashmap
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		int len = s.length();
		for(char c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		
		boolean flag = false;
		Character oddCharOut = null;
		List<Character> characters = new ArrayList<Character>();
		for(char c : charCount.keySet()) {
			int count = charCount.get(c);
			if(len % 2 == 0 ) {	
				if(count % 2 != 0) {
					return new ArrayList<String>();
				}else {
					populateCharacters(characters, count/2, c);
				}
			}else {
				if(count % 2 == 0) {
					populateCharacters(characters, count/2, c);
				}else {
					if(flag) {
						return new ArrayList<String>();
					}else {
						flag = true;
						oddCharOut = c;
						charCount.put(c, count - 1);
						populateCharacters(characters, (count - 1)/2, c);
					}
				}
			}
		}
		List<String> finalAnswers = new ArrayList<String>();
		if(charCount.size() == 1) {
			finalAnswers.add(s);
			return finalAnswers;
		}
		Set<String> halfAnswers = new HashSet<String>();
		StringBuilder halfAnswer = new StringBuilder();
		backtrack(halfAnswers, halfAnswer, characters);
		
		for(String t : halfAnswers) {
			if(oddCharOut == null) {
				finalAnswers.add(t + new StringBuilder(t).reverse().toString());
			}else {
				finalAnswers.add(t + oddCharOut + new StringBuilder(t).reverse().toString());
			}
		}
		return finalAnswers;
		
    }
	
	private void populateCharacters(List<Character> characters, int count, char c) {
		for(int i = 0; i < count;i++) {
			characters.add(c);
		}
	}
	
	private void backtrack(Set<String> halfAnswers, StringBuilder halfAnswer, List<Character> characters) {
		if(characters.isEmpty()) {
			halfAnswers.add(halfAnswer.toString());
			return;
		}
		
		for(int i = 0; i < characters.size(); i++) {
			char temp = characters.get(i);
			characters.remove(i);
			halfAnswer.append(temp);
			backtrack(halfAnswers, halfAnswer, characters);
			halfAnswer.deleteCharAt(halfAnswer.length()-1);
			characters.add(i, temp);
		}
	}
	
	public static void main(String[] args) {
		List<String> temp = new PalindromePermutation2().generatePalindromes("aabbc");
		for(String gg : temp) {
			System.out.println(gg);
		}
	}

}
