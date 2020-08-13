package edu.stonybrook.pnarendra.easy;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
        	switch(c) {
        	case '(': stack.push(c);
        				break;
        	case '[': stack.push(c);
						break;
        	case '{': stack.push(c);
						break;						
        	case ')' :  if(stack.isEmpty()) {
							return false;
						}
        				Character temp = stack.peek();
        				if(temp == null) {
        					return false;
        				}else if(temp == '(') {
        					stack.pop();
        				}else {
        					return false;
        				}
        				break;
        	case ']': 	if(stack.isEmpty()) {
        					return false;
        				}
        				temp = stack.peek();
						if(temp == null) {
							return false;
						}else if(temp == '[') {
							stack.pop();
						}else {
							return false;
						}
						break;
        	case '}' : 	if(stack.isEmpty()) {
							return false;
						}
        				temp = stack.peek();
						if(temp == null) {
							return false;
						}else if(temp == '{') {
							stack.pop();
						}else {
							return false;
						}
						break;
        	}
        }
        return stack.empty();
    }

}
