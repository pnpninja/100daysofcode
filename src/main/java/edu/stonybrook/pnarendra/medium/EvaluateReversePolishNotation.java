package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
        	if(token.equals("*")) {
        		int t1 = stack.pop();
        		int t2 = stack.pop();
        		t1 = t1 * t2;
        		stack.push(t1);
        	}else if(token.equals("+")) {
        		int t1 = stack.pop();
        		int t2 = stack.pop();
        		t1 = t1 + t2;
        		stack.push(t1);
        	}else if(token.equals("-")) {
        		int t1 = stack.pop();
        		int t2 = stack.pop();
        		t1 = t1 - t2;
        		stack.push(t1);
        	}else if(token.equals("/")) {
        		int t1 = stack.pop();
        		int t2 = stack.pop();
        		t1 = t1 / t2;
        		stack.push(t1);
        	}else {
        		stack.push(Integer.parseInt(token));
        	}
        }
        return stack.pop();
    }
	

}
