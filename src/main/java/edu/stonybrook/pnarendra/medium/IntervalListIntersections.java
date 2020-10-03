package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	
	public int[][] intervalIntersection(int[][] A, int[][] B) {
	    List<int[]> answer = new ArrayList<int[]>();
	    int Aiter = 0, Biter = 0;
	    while(Aiter < A.length && Biter < B.length) {
	    	int start = Math.max(A[Aiter][0], B[Biter][0]);
	    	int end = Math.min(A[Aiter][1], B[Biter][1]);
	    	
	    	if(start <= end) {
	    		answer.add(new int[] {start,end});
	    	}
	    	
	    	if(A[Aiter][1] < B[Biter][1]) {
	    		Aiter++;
	    	}else {
	    		Biter++;
	    	}
	    }
	    
	    int[][] anss = new int[answer.size()][2];
	    for(int i = 0; i < answer.size(); i++) {
	    	anss[i] = answer.get(i);
	    }
	    return anss;
	 }
	
	public static void main(String[] args) {
		IntervalListIntersections gg = new IntervalListIntersections();
		int[][] arr1 = new int[][] {{0,2},{5,10},{13,23},{24,25}};
		int[][] arr2 = new int[][] {{1,5},{8,12},{15,24},{25,26}};
		System.out.println(gg.intervalIntersection(arr1, arr2));
	}
	

}
