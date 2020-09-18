package edu.stonybrook.pnarendra.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {

	public String minRemoveToMakeValid(String s) {
		return reverseStringWithBracket(process(reverseStringWithBracket(process(s))));
	}

	private String process(String input) {
		Stack<Character> stack = new Stack<>();
		Set<Integer> indicesToRemove = new HashSet<>();
		for (int index = 0; index < input.length(); index++) {
			switch (input.charAt(index)) {
			case '(':
				stack.push('(');
				break;
			case ')':
				if(stack.isEmpty()) {
					indicesToRemove.add(index);
				}else {
					stack.pop();
				}
				break;
			default:
				break;

			}
		}
		StringBuilder sb = new StringBuilder();
		for(int index = 0; index < input.length(); index++) {
			if(!indicesToRemove.contains(index)) {
				sb.append(input.charAt(index));
			}
		}
		return sb.toString();
	}

	private String reverseStringWithBracket(String input) {
		StringBuilder sb = new StringBuilder();
		int iter = input.length() - 1;
		while (iter >= 0) {
			if (input.charAt(iter) == '(') {
				sb.append(')');
			} else if (input.charAt(iter) == ')') {
				sb.append('(');
			} else {
				sb.append(input.charAt(iter));
			}
			iter--;
		}
		return sb.toString();
	}

}
