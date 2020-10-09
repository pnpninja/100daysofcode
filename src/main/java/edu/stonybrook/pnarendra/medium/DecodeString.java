package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

public class DecodeString {
	
	public String decodeString(String s) {
        Stack<String> tempStringStack = new Stack<String>();
        tempStringStack.push("");
        Stack<Integer> countStack = new Stack<Integer>();
        int iter = 0;
        while(iter < s.length()) {
        	if(Character.isDigit(s.charAt(iter))) {
        		int iter2 = iter;
        		while(Character.isDigit(s.charAt(iter2))) {
        			iter2++;
        		}
        		countStack.push(Integer.parseInt(s.substring(iter, iter2)));
        		iter = iter2;
        	}else if(s.charAt(iter) == '[') {
        		tempStringStack.push("");
        		iter++;
        	}else if(s.charAt(iter) == ']') {
        		String x = "";
        		int tt = countStack.pop();
        		for(int i = 0; i < tt; i++) {
        			x = x + tempStringStack.peek();
        		}
        		tempStringStack.pop();
        		String y = tempStringStack.pop();
        		y = y + x;
        		tempStringStack.push(y);
        		iter++;
        	}else {
        		String g = tempStringStack.pop();
        		g = g + s.charAt(iter);
        		tempStringStack.push(g);
        		iter++;
        	}
        }
        return tempStringStack.pop();
        
        
    }
	

}
