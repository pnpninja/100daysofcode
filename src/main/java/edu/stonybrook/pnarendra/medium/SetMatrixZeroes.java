package edu.stonybrook.pnarendra.medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {

		Set<Integer> zeroRows = new HashSet<Integer>();
		Set<Integer> zeroCols = new HashSet<Integer>();
		int rows = matrix.length, cols = matrix[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (matrix[row][col] == 0) {
					zeroRows.add(row);
					zeroCols.add(col);
				}
			}
		}

		for (int row : zeroRows) {
			for (int i = 0; i < cols; i++) {
				matrix[row][i] = 0;
			}
		}

		for (int col : zeroCols) {
			for (int i = 0; i < rows; i++) {
				matrix[i][col] = 0;
			}
		}
	}

}
