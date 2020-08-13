package edu.stonybrook.pnarendra.medium;

// 8
// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToInteger {
	
	public int myAtoi(String str) {
		if (null == str || str.length() <= 0) return 0;
        int i = 0, len = str.length();
        // ignore heading blanks
        while (i < len && str.charAt(i) == ' ') i++;
        if (i >= len) return 0;
        // check +/-
        boolean negative = false;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            negative = str.charAt(i++) == '-';
        }
        // check first bit after +/-
        if (i >= len || !isNumeric(str.charAt(i))) return 0;
        // convert left str to num
        int num = 0;
        while (i < len && isNumeric(str.charAt(i))) {
            int low = str.charAt(i) - '0';
            if (negative && num < (Integer.MIN_VALUE + low) / 10) {
                return Integer.MIN_VALUE;
            } else if (!negative && num > (Integer.MAX_VALUE - low) / 10) {
                return Integer.MAX_VALUE;
            }
            num = negative ? (num * 10 - low) : (num * 10 + low);
            i++;
        }
        return num;
    }
	
	private boolean isNumeric(char ch) {
        return ch >= '0' && ch <= '9';
    }

}
