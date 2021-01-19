package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

public class ValidateStackSequences {
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        int n = pushed.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int x : pushed) {
        	stack.push(x);
        	while(!stack.isEmpty() && popped[j] == stack.peek()) {
        		stack.pop();
        		j++;
        	}
        }
        return j == n;
    }

}
