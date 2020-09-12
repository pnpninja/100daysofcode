package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

public class KLengthSubStringsWithNoRepeatedCharacters {
	
	public int numKLenSubstrNoRepeats(String S, int K) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        int pointer = 0;
        while(pointer < S.length()) {
        	if(pointer < K) {
        		increment(map,S.charAt(pointer));
        	}else {
        		if(map.size() == K) {
        			count++;
        		}
        		decrement(map, S.charAt(pointer - K));
        		increment(map, S.charAt(pointer));
        	}
        	pointer++;
        }
        return count + (map.size() == K ? 1 : 0);
    }
	
	private void decrement(Map<Character, Integer> map, char c) {		
		if(map.get(c) == 1) {
			map.remove(c);
		}else {
			map.put(c, map.get(c) - 1);
		}
	}
	
	private void increment(Map<Character, Integer> map, char c) {
		map.put(c, map.getOrDefault(c, 0) + 1);
	}

	
	public static void main(String[] args) {
		System.out.println(new KLengthSubStringsWithNoRepeatedCharacters().numKLenSubstrNoRepeats("abab", 2));
	}
}
