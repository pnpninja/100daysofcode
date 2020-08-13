package edu.stonybrook.pnarendra.easy;

// 125
// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
        	while(start < arr.length && !isValidChar(arr[start])){
        		start++;
        	}
        	
        	while(end >= 0 && !isValidChar(arr[end])){
        		end--;
        	}
        	
        	if(start > end) {
        		return true;
        	}
        	
        	if(start < arr.length && end >= 0 && arr[start] != arr[end]) {
        		return false;
        	}else if(start >= arr.length || end < 0){
        		return false;
        	}else {
        		start++;
        		end--;
        	}
        }
        return true;
    }
	
	private boolean isValidChar(char c) {
		if(c >= 'a' && c <= 'z') {
			return true;
		}else if(c >= 'A' && c <= 'Z') {
			return true;
		}else if(c >= '0' && c <= '9'){
			return true;
		}else{
            return false;
        }
	}

}
