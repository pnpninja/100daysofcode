package edu.stonybrook.pnarendra.easy;

// 344
// https://leetcode.com/problems/reverse-string/
public class ReverseString {
	public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        
        while(left < right) {
        	temp = s[left];
        	s[left] = s[right];
        	s[right] = temp;
        	left++;
        	right--;
        	
        }
        
    }
}
