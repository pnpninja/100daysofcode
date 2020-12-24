package edu.stonybrook.pnarendra.easy;

import java.util.Stack;

public class AddStrings {
	
	public String addStrings(String num1, String num2) {
        int num1Index = num1.length()-1;
        int num2Index = num2.length()-1;
        Stack<Integer> stack = new Stack<Integer>();
        int carry = 0;
        int sum = 0;
        while(true) {
        	if(num1Index == -1 && num2Index == -1) {
        		break;
        	}else if(num1Index == -1) {
        		int temp = (num2.charAt(num2Index)-48)+carry;
        		stack.push(temp%10);
        		carry = temp/10;
        		num2Index--;
        	}else if(num2Index == -1) {
        		int temp = (num1.charAt(num1Index)-48)+carry;
        		stack.push(temp%10);
        		carry = temp/10;
        		num1Index--;
        	}else {
        		int temp = (num1.charAt(num1Index)-48)+(num2.charAt(num2Index)-48)+carry;
        		stack.push(temp%10);
        		carry = temp/10;
        		num1Index--;
        		num2Index--;
        	}
        }
        if(carry!=0) {
        	stack.push(carry);
        }
        StringBuilder temp = new StringBuilder();
        while(!stack.isEmpty()) {
        	temp.append(stack.pop());
        }
        return temp.toString();
    }

}
