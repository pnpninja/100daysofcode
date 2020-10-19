package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

public class ReverseSubstringBetweenParentheses {
	public String reverseParentheses(String s) {
        Stack<String> strStack = new Stack<String>();
        strStack.push("");
        for(char c : s.toCharArray()) {
        	if(c == '(') {
        		strStack.add("");
        	}else if(c == ')') {
        		String t = strStack.pop();
        		t = new StringBuilder(t).reverse().toString();
        		strStack.push(strStack.pop() + t);
        	}else {
        		strStack.push(strStack.pop() + c);
        	}
        }
        return strStack.pop();
        
    }
}
