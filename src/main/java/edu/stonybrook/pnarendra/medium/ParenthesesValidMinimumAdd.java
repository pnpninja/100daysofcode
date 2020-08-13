package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

// 921
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class ParenthesesValidMinimumAdd {
	public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : S.toCharArray()) {
        	if(c == '(') {
        		stack.push(c);
        	}else {
        		if(!stack.isEmpty() && stack.peek()=='(') {
        			stack.pop();
        		}else {
        			stack.push(c);
        		}
        	}
        }
        return stack.size();
    }

}
