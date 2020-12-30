package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

class DS3{
	char c;
	int count;
	
	public DS3(char c, int count) {
		this.c = c;
		this.count = count;
	}
}
public class ExpressiveWords {
	public int expressiveWords(String S, String[] words) {
        List<DS3> t1 = generateCompress(S);
        int count = 0;
        for(String word : words) {
        	if(isExpressive(t1,generateCompress(word))) {
        		count++;
        	}
        }
        return count;
    }
	
	private List<DS3> generateCompress(String s){
		List<DS3> answer = new ArrayList<DS3>();
		int pointer = 0;
		char c;
		int count;
		while(pointer < s.length()) {
			c = s.charAt(pointer);
			count = 1;
			int tempPointer = pointer+1;
			while(tempPointer < s.length()) {
				if(s.charAt(tempPointer) == s.charAt(pointer)) {
					count++;
					tempPointer++;
				}else {
					break;
				}
			}
			answer.add(new DS3(c,count));
			pointer = tempPointer;
		}
		return answer;
	}
	
	private boolean isExpressive(List<DS3> t1, List<DS3> t2) {
		if(t1.size() != t2.size()) {
			return false;
		}
		
		boolean isValid = true;
		for(int i = 0; i < t1.size();i++) {
			if(t1.get(i).c != t2.get(i).c) {
				isValid = false;
				break;
			}else if(t1.get(i).count < t2.get(i).count) {
				isValid = false;
				break;
			}else if(t1.get(i).count > t2.get(i).count && t1.get(i).count < 3) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}
	
}
