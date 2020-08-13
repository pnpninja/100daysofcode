package edu.stonybrook.pnarendra.medium;

// 43
// https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
	
	public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int size1 = num1.length(), size2 = num2.length();
        int[] res = new int[size1 + size2];
        for (int i = size1 - 1; i >= 0; --i){
            int x = Character.getNumericValue(num1.charAt(i));
            for (int j = size2 - 1; j >= 0; --j){
                int y = Character.getNumericValue(num2.charAt(j));
                int pos1 = i + j + 1;
                int pos2 = i + j;
                int prod = x * y;
                res[pos1] += prod % 10;
                res[pos2] += prod / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = size1 + size2 - 1; i >= 0; --i){
            if (i == 0 && res[i] == 0)
                continue;
            sb.append(res[i] % 10);
            if (res[i] >= 10){
                res[i-1] += res[i] / 10;
            }
        }
        return sb.reverse().toString();
    }
}
