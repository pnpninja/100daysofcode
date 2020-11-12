package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordLadder2 {
	
	int minLength = Integer.MAX_VALUE;
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> answers = new ArrayList<List<String>>();
        List<String> answer = new ArrayList<String>();
        Set<String> wordDict = new HashSet<String>(wordList);
        if(!wordDict.contains(endWord)) {
        	return answers;
        }
        answer.add(beginWord);
        backtrack(answers,answer,beginWord,endWord,wordDict);
        return answers;
    }
	
	public void backtrack(List<List<String>> answers, List<String> answer,String beginWord, String endWord, Set<String> wordDict) {
		if(beginWord.equals(endWord)) {
			if(answer.size() < minLength) {
				answers.clear();
				answers.add(new ArrayList<String>(answer));
				minLength = answer.size();
				return;
			}else if(answer.size() == minLength) {
				answers.add(new ArrayList<String>(answer));
				return;
			}else {
				return;

			}
		}
		
		if(wordDict.isEmpty() && !beginWord.equals(endWord)) {
			return;
		}
		
		String temp = answer.get(answer.size() - 1);
		int len = temp.length();
		for(int i = 0; i < len;i++) {
			String nextReg = temp.substring(0,i)+"."+temp.substring(i+1,len);
			Pattern r = Pattern.compile(nextReg);
			List<String> matches = wordDict.parallelStream().filter(line -> line.matches(nextReg)).collect(Collectors.toList());
			for(String match : matches) {
				wordDict.remove(match);
				answer.add(match);
				backtrack(answers, answer, match, endWord, wordDict);
				wordDict.add(match);
				answer.remove(answer.size() - 1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		WordLadder2 wd2 = new WordLadder2();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		List<List<String>> x = wd2.findLadders(beginWord, endWord, wordList);
		System.out.println("Here");
	}

}
