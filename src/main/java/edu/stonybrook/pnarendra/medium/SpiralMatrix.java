package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> answer = new ArrayList<Integer>();
        if(matrix.length == 0){
            return answer;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int rowTop = 0;
        int rowBottom = rows - 1;
        int colLeft = 0;
        int colRight = cols - 1;
        
        while(rowTop <= rowBottom && colLeft <= colRight) {
        	for(int colIter = colLeft; colIter <= colRight; colIter++) {
        		answer.add(matrix[rowTop][colIter]);
        	}
        	for(int rowIter = rowTop + 1; rowIter <= rowBottom; rowIter++) {
        		answer.add(matrix[rowIter][colRight]);
        	}
        	if(rowTop < rowBottom && colLeft < colRight) {
        		for(int colIter = colRight  - 1; colIter > colLeft; colIter--) {
            		answer.add(matrix[rowBottom][colIter]);
            	}
        		for(int rowIter = rowBottom; rowIter > rowTop; rowIter--) {
            		answer.add(matrix[rowIter][colLeft]);
            	}
        		
        	}
        	rowTop++;
        	rowBottom--;
        	colLeft++;
        	colRight--;       	
        }
        return answer;
    }
}
