package edu.stonybrook.pnarendra.hard;

import java.util.HashMap;

class DS{
	HashMap<Character,Integer> validChars;
	HashMap<Character,Integer> currentChars;
	
	public DS(String t) {
		this.validChars = new HashMap<Character,Integer>();
		this.currentChars = new HashMap<Character,Integer>();
		for(char s : t.toCharArray()) {
			this.validChars.put(s, this.validChars.getOrDefault(s, 0)+1);
		}
	}
	
	public boolean containsAll() {
		boolean flag = true;
		if(!this.currentChars.keySet().containsAll(this.validChars.keySet())) {
			return false;
		}else {
			for(char c : this.validChars.keySet()) {
				if(this.validChars.get(c) > this.currentChars.get(c)) {
					flag = false;
				}
			}
			return flag;
		}
	}
	
	public void addChar(char c) {
		if(this.validChars.containsKey(c)) {
			this.currentChars.put(c, this.currentChars.getOrDefault(c, 0)+1);
		}	
	}
	
	public void removeChar(char c) {
		if(this.validChars.containsKey(c)) {
			this.currentChars.put(c, this.currentChars.get(c)-1);
			if(this.currentChars.get(c) <= 0) {
				this.currentChars.remove(c);
			}
		}
		
	}
	
}
public class MinimumWindowSubstring {
	
	public String minWindow(String s, String t) {
        DS ds = new DS(t);
        int leftIndex = 0;
        int rightIndex = 0;
        ds.addChar(s.charAt(0));
        String minAnswer = null;
        while(leftIndex <= rightIndex && rightIndex < s.length()) {
        	if(!ds.containsAll()) {
        		if(rightIndex + 1== s.length()) {
        			break;
        		}else {
        			ds.addChar(s.charAt(rightIndex+1));
        			rightIndex++;
        		}
        	}else {
        		if(minAnswer == null) {
        			minAnswer = s.substring(leftIndex, rightIndex+1);
        		}else {
        			if(rightIndex - leftIndex + 1 < minAnswer.length()) {
        				minAnswer = s.substring(leftIndex, rightIndex+1);
        			}
        		}
        		ds.removeChar(s.charAt(leftIndex));
        		leftIndex++;
        	}
        }
        return minAnswer == null ? "" : minAnswer;
        
    }
	
	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
	}

}
