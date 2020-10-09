package edu.stonybrook.pnarendra.medium;

public class CandyCrush {
	
	public int[][] candyCrush(int[][] board) {
        boolean foundAChange = false;
        //check rows
        for(int row = 0; row < board.length; row++) {
        	for(int col = 0;col < board.length - 2; col++) {
        		if(Math.abs(board[row][col]) == Math.abs(board[row][col + 1]) && Math.abs(board[row][col + 1]) == Math.abs(board[row][col + 2]) && Math.abs(board[row][col]) != 0) {
        			foundAChange = true;
        			board[row][col] = -Math.abs(board[row][col]);
        			board[row][col + 1] = -Math.abs(board[row][col + 1]);
        			board[row][col + 2] = -Math.abs(board[row][col + 2]);
        		}
        	}
        }
        
        // check columns
        for(int row = 0; row < board.length - 2; row++) {
        	for(int col = 0;col < board.length; col++) {
        		if(Math.abs(board[row][col]) == Math.abs(board[row + 1][col]) && Math.abs(board[row + 1][col]) == Math.abs(board[row + 2][col]) && Math.abs(board[row][col]) != 0) {
        			foundAChange = true;
        			board[row][col] = -Math.abs(board[row][col]);
        			board[row + 1][col] = -Math.abs(board[row][col]);
        			board[row + 2][col] = -Math.abs(board[row][col]);
        		}
        	}
        }
        
        //compress
        for(int col = 0; col < board[0].length; col++) {
        	int start = board.length - 1;
        	for(int row = board.length - 1; row >= 0; row--) {
        		if(board[row][col] != 0) {
        			board[start--][col] = board[row][col];
        		}
        	}
        	while(start >= 0) {
        		board[start--][col] = 0;
        	}
        }
        
        return foundAChange ? candyCrush(board) : board;
        
       
        
        
    }

}
