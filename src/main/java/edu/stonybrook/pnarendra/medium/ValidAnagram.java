package edu.stonybrook.pnarendra.medium;

public class ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
        int[] charcount = new int[26];
        if(s.length() != t.length()) {
        	return false;
        }
        for(int i = 0; i < s.length(); i++) {
        	charcount[s.charAt(i) - 97]++;
        	charcount[t.charAt(i) - 97]--;
        }
        
        for(int i = 0; i < 26; i++) {
        	if(charcount[i] < 0) {
        		return false;
        	}
        }
        return true;
    }

}
