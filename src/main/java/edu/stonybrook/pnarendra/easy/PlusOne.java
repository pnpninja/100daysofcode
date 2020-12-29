package edu.stonybrook.pnarendra.easy;

import com.sun.org.apache.xpath.internal.operations.Plus;

public class PlusOne {
	
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length-1]++;
        int t = 0;
        for(int i = digits.length-1; i>=0; i--) {
        	t = (digits[i]+carry)%10;
        	carry = (digits[i]+carry)/10;
        	digits[i] = t;
        }
        if(carry == 0) {
        	return digits;
        }else {
        	int[] digits2 = new int[digits.length+1];
        	for(int i = 0; i < digits.length;i++) {
        		digits2[i+1] = digits[i];
        	}
        	digits2[0] = carry;
        	return digits2;
        }
        
    }
    
    public static void main(String[] args) {
		new PlusOne().plusOne(new int[] {9,9,9});
	}

}
