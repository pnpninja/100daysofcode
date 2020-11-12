package edu.stonybrook.pnarendra.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	
	public static String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedWords = new HashSet<String>();
		for(String bannedWord : banned) {
			bannedWords.add(bannedWord);
		}
        Map<String, Integer> map = new HashMap<>();
        paragraph = paragraph.replaceAll(",", " ");
        paragraph = paragraph.replaceAll("\\."," ");
        paragraph = paragraph.replaceAll("\\?", " ");
        paragraph = paragraph.replaceAll("!", " ");
        paragraph = paragraph.replaceAll("'", " ");
        paragraph = paragraph.replaceAll(";", " ");
        paragraph = paragraph.replaceAll(" +", " ");
        
        String[] words = paragraph.split(" ");
        String mostFreqWord = "";
        int mostFreqCount = 0;
        for(String word : words) {
        	String temp = word.toLowerCase();
        	if(!bannedWords.contains(temp)) {
        		map.put(temp, map.getOrDefault(temp, 0) + 1);
        		if(map.get(temp) > mostFreqCount) {
        			mostFreqWord = temp;
        			mostFreqCount = map.get(temp);
        		}
        	}
        }
        return mostFreqWord;
        		
    }
	
	public static void main(String[] args) {
		mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
	}

}
