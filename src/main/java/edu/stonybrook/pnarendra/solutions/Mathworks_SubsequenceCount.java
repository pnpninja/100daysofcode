package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.List;

public class Mathworks_SubsequenceCount {

	static int count(String a, String b) 
	{ 
	    int m = a.length(); 
	    int n = b.length(); 
	  
	    int[][] lookup = new int[n + 1][m + 1];
	    
	    for(int i = 0; i <=m; i++) {
	    	lookup[0][i] = 1;
	    }
	    
	    for(int i = 1; i <= n; i++) {
	    	lookup[i][0] = 0;
	    }
	    
	    for(int row = 1; row <= n; row++) {
	    	for(int col = 1; col <= m; col++) {
	    		if(a.charAt(col - 1) == b.charAt(row - 1)) {
	    			lookup[row][col] = lookup[row][col - 1] + lookup[row - 1][col - 1];
	    		}else {
	    			lookup[row][col] = lookup[row][col - 1];
	    		}
	    	}
	    }
	    return lookup[n][m];
	    
	} 
	
	public static void main (String[] args) 
	{ 
	    String a = "GeeksforGeeks"; 
	    String b = "Gks"; 
	      
	    System.out.println(count(a, b)); 
	} 
	
}
