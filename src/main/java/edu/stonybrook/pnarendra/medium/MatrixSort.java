package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


// 1329
// https://leetcode.com/problems/sort-the-matrix-diagonally/
public class MatrixSort {
	public int[][] diagonalSort(int[][] mat) {
        for(int i = 0; i < mat[0].length; i++) {
        	sortDiagonal(mat, 0, i);
        }
        for(int i = 1; i < mat.length; i++) {
        	sortDiagonal(mat, i, 0);
        }
        return mat;
    }
	
	private void sortDiagonal(int[][] mat, int row, int col){
		List<Integer> list = new ArrayList<Integer>();
		int rowIter = row;
		int coliter = col;
		while(rowIter < mat.length && coliter < mat[0].length) {
			list.add(mat[rowIter][coliter]);
			rowIter++;
			coliter++;
		}
		Collections.sort(list);
		rowIter = row;
		coliter = col;
		while(rowIter < mat.length && coliter < mat[0].length) {
			mat[rowIter++][coliter++] = list.remove(0);
		}
		return;
		
	}
}
