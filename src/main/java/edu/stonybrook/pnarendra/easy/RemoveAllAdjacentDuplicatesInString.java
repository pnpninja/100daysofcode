package edu.stonybrook.pnarendra.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class RemoveAllAdjacentDuplicatesInString {
	
	public String removeDuplicates(String input) {
		Stack<Character> stack = new Stack<Character>();
		for(char c : input.toCharArray()) {
			if(stack.isEmpty()) {
				stack.push(c);
			}else if(stack.peek() == c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		StringBuilder ans = new StringBuilder();
		while(!stack.isEmpty()) {
			ans.append(stack.pop());
		}
		return ans.reverse().toString();
		
	}
	

}
