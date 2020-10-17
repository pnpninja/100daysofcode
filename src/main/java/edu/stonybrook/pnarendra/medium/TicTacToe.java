package edu.stonybrook.pnarendra.medium;

public class TicTacToe {
	
	/** Initialize your data structure here. */
	int[][] board;
    public TicTacToe(int n) {
        this.board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        int rc = rowCheck();
        if(rc!=0) {
        	return rc;
        }
        int cc = colCheck();
        if(cc!=0) {
        	return cc;
        }
        
        int dc = diagonalCheck();
        if(dc != 0) {
        	return dc;
        }
        return 0;
    }
   
    
    private int rowCheck() {
    	for(int row = 0; row < board.length; row++) {
    		if(board[row][0]!=0){
    			int val = board[row][0];
        		boolean rowFilled = true;
        		for(int col = 1; col < board[0].length;col++) {
        			if(val != board[row][col]) {
        				rowFilled = false;
        				break;
        			}
        		}
        		if(rowFilled) {
        			return val;
        		}
    		}
    	}
    	return 0;
    }
    
    private int colCheck() {
    	for(int col = 0; col < board[0].length; col++) {
    		if(board[0][col]!=0){
    			int val = board[0][col];
        		boolean colFilled = true;
        		for(int row = 1; row < board.length;row++) {
        			if(val != board[row][col]) {
        				colFilled = false;
        				break;
        			}
        		}
        		if(colFilled) {
        			return val;
        		}
    		}
    	}
    	return 0;
    }
    
    private int diagonalCheck() {
    	return Math.max(principalDiagonalCheck(), secondaryDiagonalCheck());
    }
    
    private int principalDiagonalCheck() {
    	int row = 0;
		int col = 0;
		int rows = board.length;
		int cols = board[0].length;
		int first = board[row][col];
		if(first == 0) {
			return 0;
		}
		boolean diagFilled = true;
		row++;
		col++;
		while(row < rows && col < cols) {
			if(board[row][col] != first) {
				diagFilled = false;
				break;
			}
			row++;
			col++;
		}
		if(diagFilled) {
			return first;
		}else {
			return 0;
		}
    }
    
    private int secondaryDiagonalCheck() {
    	int row = 0;
		int col = board[0].length - 1;
		int rows = board.length;
		int cols = board[0].length;
		int first = board[row][col];
		if(first == 0) {
			return 0;
		}
		boolean diagFilled = true;
		row++;
		col--;
		while(row < rows && col >= 0) {
			if(board[row][col] != first) {
				diagFilled = false;
				break;
			}
			row++;
			col--;
		}
		if(diagFilled) {
			return first;
		}else {
			return 0;
		}
    }
    
    public static void main(String[] args) {
//		TicTacToe ttb = new TicTacToe(4);
//		ttb.move(0, 3, 1);
//		ttb.move(3, 3, 2);
//		ttb.move(3, 0, 1);
//		ttb.move(0, 0, 2);
//		ttb.move(2, 1, 1);
//		ttb.move(2, 2, 2);
//		ttb.move(1, 2, 1);
		
		TicTacToe ttb = new TicTacToe(2);
		ttb.move(0, 1, 1);
		ttb.move(1, 1, 2);
		ttb.move(1, 0, 1);
		
		
		
		
	}

}
