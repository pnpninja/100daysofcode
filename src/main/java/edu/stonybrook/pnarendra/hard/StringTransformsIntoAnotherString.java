package edu.stonybrook.pnarendra.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTransformsIntoAnotherString {
	public boolean canConvert(String str1, String str2) {
		Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        if(str1.length() != str2.length()) {
        	return false;
        }
        
        for(int i = 0;i < str1.length(); i++) {
        	if(map.containsKey(str1.charAt(i))) {
        		if(map.get(str1.charAt(i)) != str2.charAt(i)) {
        			return false;
        		}else {
        			continue;
        		}
        	}else {
        		map.put(str1.charAt(i), str2.charAt(i));
                set.add(str2.charAt(i));
        	}
        }
        if(!str1.equals(str2) && map.size() == 26 && set.size() == 26){
            return false;
        }
        return true;
        
    }
}
