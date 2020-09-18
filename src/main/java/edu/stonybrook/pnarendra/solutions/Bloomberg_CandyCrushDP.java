package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Object2{
	public char character;
	public int currentCount;
}
public class Bloomberg_CandyCrushDP {
	
	public String crushString(String input) {
		List<Object2> stack = new ArrayList<Object2>();
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
	
	private void compressString(List<Object2> stack) {
		if(stack.isEmpty()) {
			return;
		}else {
			while(true) {
				if(stack.isEmpty()) {
					break;
				}else {
					Object2 lastObject = stack.get(stack.size() - 1);
					if(lastObject.currentCount >= 3) {
						stack.remove(lastObject);
					}
					break;
				}
			}
		}
	}
	
	private void addToStack(List<Object2> stack,char c) {
		if(stack.isEmpty()) {
			Object2 newObject = new Object2();
			newObject.character = c;
			newObject.currentCount = 1;
			stack.add(newObject);
		}else {
			Object2 lastObject = stack.get(stack.size() - 1);
			if(lastObject.character == c) {
				lastObject.currentCount++;
			}else {
				Object2 newObject = new Object2();
				newObject.character = c;
				newObject.currentCount = 1;
				stack.add(newObject);
			}
		}
	}
	
	private String prepareOutput(List<Object2> stack) {
		StringBuilder sb = new StringBuilder();
		for(Object2 obj : stack) {
			for(int i = 0; i < obj.currentCount;i++) {
				sb.append(obj.character);
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		String input = "aaabbbacd";
		input = "aabbbaaac";
		input = new StringBuilder(input).reverse().toString();
		String temp = new Bloomberg_CandyCrush().crushString(input);
		System.out.println(new StringBuilder(temp).reverse().toString());
		
	}
}