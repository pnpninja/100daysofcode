package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquares {
	
	Map<String, List<String>> prefixMap;
	public List<List<String>> wordSquares(String[] words) {
        this.prefixMap = new HashMap<String,List<String>>();
        createPrefixMap(words);
        List<List<String>> answers = new ArrayList<List<String>>();
        for(int i = 0; i < words.length;i++) {
        	List<String> list = new ArrayList<String>();
        	list.add(words[i]);
        	backtrack(list,answers,1,words[i].length());
        }
        return answers;
        
    }
	
	public void backtrack(List<String> list, List<List<String>> answers, int step, int n) {
		if(step == n) {
			answers.add(new ArrayList<String>(list));
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(String word : list) {
			sb.append(word.charAt(step));
		}
		String prefix = sb.toString();
		List<String> wordList = this.prefixMap.getOrDefault(prefix, new ArrayList<String>());
		for(String word : wordList) {
			list.add(word);
			backtrack(list,answers,step+1,n);
			list.remove(list.size() - 1);
		}
		
	}
	
	public void createPrefixMap(String[] words) {
		for(String word: words) {
			for(int i = 0; i < word.length();i++) {
				String prefix = word.substring(0,i);
				this.prefixMap.putIfAbsent(prefix, new ArrayList<String>());
				List<String> list = this.prefixMap.get(prefix);
				list.add(word);
				this.prefixMap.put(prefix, list);
			}
		}
	}

}
