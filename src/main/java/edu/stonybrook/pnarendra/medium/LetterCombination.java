package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
	
	public List<String> letterCombinations(String digits) {
		Map<String, String> phone = new HashMap<String, String>() {{
		    put("2", "abc");
		    put("3", "def");
		    put("4", "ghi");
		    put("5", "jkl");
		    put("6", "mno");
		    put("7", "pqrs");
		    put("8", "tuv");
		    put("9", "wxyz");
		  }};
		  
		  List<String> answer = new ArrayList<String>();
		  if(digits == null || digits.length() == 0){ return answer;}
		  StringBuilder sb = new StringBuilder();
		  backtrack(answer,sb,phone,0,digits,digits.length());
		  return answer;
    }
	
	public void backtrack(List<String> answer, StringBuilder sb, Map<String, String> phone, int currIndex, String digits, int length) {
		if(currIndex == length) {
			answer.add(sb.toString());
			return;
		}
		for(char c : phone.get(Character.toString(digits.charAt(currIndex))).toCharArray()) {
			sb.append(c);
			backtrack(answer,sb,phone,currIndex+1,digits,length);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
