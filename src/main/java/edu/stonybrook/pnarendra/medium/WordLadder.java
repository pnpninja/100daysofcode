package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	public int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<String>();
        //dict.add(endWord);
        for(String word : wordList) {
        	dict.add(word);
        }
        if(!dict.contains(endWord)) {
        	return 0;
        }
        queue.add(beginWord);
        int step = 0;
        while(!queue.isEmpty()) {
        	Queue<String> level = new LinkedList<String>();
        	step++;
        	while(!queue.isEmpty()) {
        		String head = queue.poll();
        		if(head.equals(endWord)) {
        			return step;
        		}
        		int len = head.length();
        		for(int i = 0; i < len; i++) {
        			for(char c = 'a'; c <= 'z'; c++) {
        				String temp = head.substring(0, i)+c+head.substring(i+1,len);
        				if(dict.contains(temp)) {
        					level.add(temp);
        					dict.remove(temp);
        				}
        			}
        			
        		}
        	}
        	queue = level;
        }
        return 0;

    }


}
