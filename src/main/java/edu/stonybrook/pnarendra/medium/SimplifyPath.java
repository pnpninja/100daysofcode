package edu.stonybrook.pnarendra.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class SimplifyPath {
	
	public String simplifyPath(String path) {
        String[] paths = path.replaceAll("//", "/").replaceAll("/$","").split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for(int i = 1; i < paths.length; i++) {
        	if(paths[i].equals(".")) {
        		continue;
        	}else if(paths[i].equals("..")) {
        		stack.pop();
        	}else {
        		stack.push(paths[i]);
        	}
        }
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        while(!stack.isEmpty()) {
        	if(stack.size() == 1) {
        		sb.append(stack.removeLast());
        	}else {
        		sb.append(stack.removeLast()+"/");
        	}
        	
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		new SimplifyPath().simplifyPath("/../");
	}

}
