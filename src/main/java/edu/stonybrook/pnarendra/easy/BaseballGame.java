package edu.stonybrook.pnarendra.easy;

import java.util.Stack;

public class BaseballGame {
	
	public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String op : ops) {
        	if(op.equals("+")) {
        		int s1 = stack.pop();
        		int s2 = stack.pop();
        		int temp1 = s1+s2;
        		stack.push(s2);
        		stack.push(s1);
        		stack.push(temp1);
        	}else if(op.equals("D")) {
        		stack.push(stack.pop() * 2);
        	}else if(op.equals("C")) {
        		stack.pop();
        	}else {
        		stack.push(Integer.parseInt(op));
        	}
        }
        int ans = 0;
        while(!stack.isEmpty()) {
        	ans+=stack.pop();
        }
        return ans;
    }

}
