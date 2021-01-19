package edu.stonybrook.pnarendra.hard;

import java.util.Stack;

public class EncodeStringWthShortestLength {
	
	public String encode(String s) {
         String[][] memo = new String[s.length()][s.length()];
         for(int len = 0; len < s.length(); len++) {
        	 for(int i = 0; i < s.length()-len; i++) {
        		 int j = i + len;
        		 String substr = s.substring(i, j + 1);
        		 if(len < 4) {
        			 memo[i][j] = substr;
        		 }else {
        			 memo[i][j] = substr;
        			 for(int k = i; k < j;k++) {
        				 if((memo[i][k] + memo[k+1][j]).length() < memo[i][j].length()) {
        					 memo[i][j] = memo[i][k] + memo[k+1][j];
        				 }
        			 }
        			 
        			 for(int k = 0; k < substr.length();k++) {
        				 String repeatedStr = substr.substring(0,k+1);
        				 if(repeatedStr != null 
        					&& substr.length()%repeatedStr.length() == 0
        					&& substr.replaceAll(repeatedStr,"").length() == 0) {
        					 String ss = (substr.length()/repeatedStr.length())+"["+memo[i][i+k]+"]";
        					 if(ss.length() < memo[i][j].length()) {
        						 memo[i][j] = ss;
        					 }
        				 }
        			 }
        		 }
        	 }
         }
         return memo[0][s.length()-1];
    }
	

}
