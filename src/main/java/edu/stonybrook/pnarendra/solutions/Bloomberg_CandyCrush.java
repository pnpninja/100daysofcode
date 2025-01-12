package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.List;

class Object{
	public char character;
	public int currentCount;
}
public class Bloomberg_CandyCrush {
	
	public String crushString(String input) {
		List<Object> stack = new ArrayList<Object>();
		int currentPointer = 0;
		while(currentPointer < input.length()) {
			if(currentPointer == 0) {
				addToStack(stack,input.charAt(currentPointer));
				currentPointer++;
			}else if(currentPointer == input.length() - 1) {
				addToStack(stack, input.charAt(currentPointer));
				compressString(stack);
				currentPointer++;
				
			}else {
				if(input.charAt(currentPointer) == input.charAt(currentPointer + 1)) {
					addToStack(stack,input.charAt(currentPointer));
				}else {
					addToStack(stack,input.charAt(currentPointer));
					compressString(stack);
				}
				currentPointer++;
			}
		}
		compressString(stack);
		return prepareOutput(stack);
		
	}
	
	private void compressString(List<Object> stack) {
		if(stack.isEmpty()) {
			return;
		}else {
			while(true) {
				if(stack.isEmpty()) {
					break;
				}else {
					Object lastObject = stack.get(stack.size() - 1);
					if(lastObject.currentCount >= 3) {
						stack.remove(lastObject);
					}
					break;
				}
			}
		}
	}
	
	private void addToStack(List<Object> stack,char c) {
		if(stack.isEmpty()) {
			Object newObject = new Object();
			newObject.character = c;
			newObject.currentCount = 1;
			stack.add(newObject);
		}else {
			Object lastObject = stack.get(stack.size() - 1);
			if(lastObject.character == c) {
				lastObject.currentCount++;
			}else {
				Object newObject = new Object();
				newObject.character = c;
				newObject.currentCount = 1;
				stack.add(newObject);
			}
		}
	}
	
	private String prepareOutput(List<Object> stack) {
		StringBuilder sb = new StringBuilder();
		for(Object obj : stack) {
			for(int i = 0; i < obj.currentCount;i++) {
				sb.append(obj.character);
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		String input = "aabbbaacd";
		//input = "aaaabbbaaabacd";
		//input = new StringBuilder(input).reverse().toString();
		String temp = new Bloomberg_CandyCrush().crushString(input);
		System.out.println(temp);
		
	}

}
