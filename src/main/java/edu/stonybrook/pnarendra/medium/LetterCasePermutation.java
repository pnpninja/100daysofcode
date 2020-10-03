package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {
	
	public List<String> letterCasePermutation(String S) {
        List<String> answers = new ArrayList<String>();
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        permute(S, sb, answers, 0, len);
        return answers;
        
    }
	
	private void permute(String S, StringBuilder sb, List<String> answers, int index, int maxLen) {
		if(index == maxLen) {
			answers.add(sb.toString());
			return;
		}
		char c = S.charAt(index);
		if(Character.isAlphabetic(c)) {
			int len = sb.length();
			sb.append(Character.toUpperCase(c));
			permute(S,sb,answers,index+1,maxLen);
			sb.setLength(len);
			sb.append(Character.toLowerCase(c));
			permute(S,sb,answers,index+1,maxLen);			
		}else {
			sb.append(S.charAt(index));
			permute(S,sb,answers,index+1,maxLen);
		}
			
	}
	
	
	

}
