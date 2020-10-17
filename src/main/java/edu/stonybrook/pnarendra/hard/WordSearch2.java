package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
	
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> answers = new HashSet<String>();
        for(int i = 0;i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		for(String word : words) {
        			char[] wordTemp = word.toCharArray();
        			if(!answers.contains(word) && backTrack(i,j,board,0,wordTemp.length,wordTemp)) {
        				answers.add(word);
        			}
        		}
        	}
        }
        return new ArrayList<String>(answers);
    }
	
	public boolean backTrack(int row, int col, char[][] board, int k, int wordSize, char[] word) {
		if(k == wordSize - 1) {
			if(word[k] == board[row][col]) {
				return true;
			}else {
				return false;
			}
		}
		
		if(board[row][col] != word[k]) {
			return false;
		}
		
		char temp = board[row][col];
		board[row][col] = ' ';
		boolean flag = false;
		if(canDoNext(row+1,col,board)) {
			flag = flag || backTrack(row+1,col,board,k+1,wordSize,word);
		}
		if(canDoNext(row-1,col,board)) {
			flag = flag || backTrack(row-1,col,board,k+1,wordSize,word);
		}
		if(canDoNext(row,col+1,board)) {
			flag = flag || backTrack(row,col+1,board,k+1,wordSize,word);
		}
		if(canDoNext(row,col-1,board)) {
			flag = flag || backTrack(row,col-1,board,k+1,wordSize,word);
		}
		board[row][col] = temp;
		return flag;	
	}
	
	public boolean isWithinLimits(int row, int col, char[][] board) {
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
			return false;
		}
		return true;
	}
	
	public boolean canDoNext(int row, int col, char[][] board) {
		if(isWithinLimits(row, col, board) && board[row][col] != ' ') {
			return true;
		}
		return false;
	}

}
