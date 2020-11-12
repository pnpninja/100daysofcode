package edu.stonybrook.pnarendra.solutions;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Hackerrank_EfficientStudy {
	

	public static int knapSack(int W, int wt[], int val[], int n) 
	{ 
	    int i, w; 
	   
		int[][] K = new int[n + 1][W + 1]; 
	  
	    // Build table K[][] in bottom up manner 
	    for (i = 0; i <= n; i++) { 
	        for (w = 0; w <= W; w++) { 
	            if (i == 0 || w == 0) 
	                K[i][w] = 0; 
	            else if (wt[i - 1] <= w) 
	                K[i][w] = Math.max( 
	                   (val[i - 1]) + K[i - 1][w - wt[i - 1]], 
	                    K[i - 1][w]); 
	            else
	                K[i][w] = K[i - 1][w]; 
	        } 
	    } 
	  
	    return K[n][W]; 
	} 

	public static int maximumLearning(List<Integer> iv, List<Integer> articles, int p) {
		int[] wt = new int[iv.size()];
		int[] val = new int[iv.size()];
		
		for(int i = 0; i < iv.size(); i++) {
			val[i] = iv.get(i);
			wt[i] = 2*articles.get(i);
		}
		return knapSack(p,wt,val,iv.size());

	}

}
