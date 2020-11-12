package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.List;

public class Intuit_WordSearch {
	static void findWord(String word, String[][] grid) {
		 boolean flag = false;
		 int rows = grid.length;
		 int cols = grid[0].length;
		List<int[]> answer = new ArrayList<>();
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(flag == true) {
					break;
				}else {
					flag = backtrack(grid,answer,i,j,rows,cols,word,0);
				}
			}
		}
		if(flag == false) {
			System.out.println("None");
		}else {
			for(int i = 0; i < answer.size(); i++) {
				System.out.println(answer.get(i)[0]+" "+answer.get(i)[1]);
			}
		}
		
	}
	static boolean backtrack(String[][] grid, List<int[]> answer, int row, int col, int rows, int cols, String word, int wordIndex) {
		if(wordIndex == word.length() - 1) {
			if(grid[row][col].equals(word.substring(wordIndex, wordIndex+1))){
				answer.add(new int[] {row,col});
				return true;
			}else {
				return false;
			}
		}
		
		if(!grid[row][col].equals(word.substring(wordIndex, wordIndex+1))) {
			return false;
		}
		
		answer.add(new int[] {row,col});
		int nextRow = row;
		int nextCol = col + 1;
		if(nextRow < rows && nextCol < cols) {
			boolean t = backtrack(grid,answer,nextRow,nextCol,rows,cols,word,wordIndex+1);
			if(t == true) {
				return true;
			}
		}

		nextRow = row + 1;
		nextCol = col;
		if(nextRow < rows && nextCol < cols) {
			boolean t = backtrack(grid,answer,nextRow,nextCol,rows,cols,word,wordIndex+1);
			if(t == true) {
				return true;
			}
		}
		
		answer.remove(answer.size() - 1);
		return false;

	}
	
	public static void main(String[] args) {
		String[][] grid = new String[][] {{"c","r","c","a","r","s"},{"a","b","i","t","n","b"},{"t","f","n","n","t","i"},{"x","s","i","i","p","t"}};
		String word = "catnip";
		findWord(word,grid);
	}

}
