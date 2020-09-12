package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Databricks_SortChessSubsquares {
	
	public int[][] sortChessSubsquares(int[][] chessboard, int[][] queries){
		//Process each query.
		for(int[] query: queries) {
			int startRow = query[0];
			int startCol = query[1];
			int siz = query[2];
			
			//Get every alternative element into 2 lists
			List<Integer> odd = new ArrayList<Integer>();
			List<Integer> even = new ArrayList<Integer>();
			
			for(int i = startRow; i < startRow + siz; i++) {
				for(int j = startCol; j < startCol + siz; j++) {
					if((i + j) % 2 == 0) {
						even.add(chessboard[i][j]);
					}else {
						odd.add(chessboard[i][j]);
					}
				}
			}		
			Collections.sort(odd);
			Collections.sort(even);
			
			int indexOdd = 0;
			int indexEven = 0;
			
			for(int i = startRow; i < startRow + siz; i++) {
				for(int j = startCol; j < startCol + siz; j++) {
					if((i + j) % 2 == 0) {
						chessboard[i][j] = even.get(indexEven++);
					}else {
						chessboard[i][j] = odd.get(indexOdd++);
					}
				}
			}
		}
		return chessboard;
	}
	
	
	public static void main(String[] args) {
		int[][] chessboard = {{1,4,3,2},{8,4,7,1},{1,5,2,1}};
		int[][] queries = {{0,1,3},{1,0,2}};
		new Databricks_SortChessSubsquares().sortChessSubsquares(chessboard, queries);
	}

}
