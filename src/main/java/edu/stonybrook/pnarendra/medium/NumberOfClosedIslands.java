package edu.stonybrook.pnarendra.medium;

public class NumberOfClosedIslands {
	public int closedIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;
        for(int row = 0; row < rows; row++) {
        	for(int col = 0; col < cols; col++) {
        		if(grid[row][col] == 0) {
        			//Check for closed island
        			if(isClosedIsland(row,col,rows,cols,grid)) {
        				count++;
        			}
        		}
        	}
        }
        return count;
    }
	
	private boolean isClosedIsland(int row, int col, int rows, int cols,int[][] grid) {
		if(row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
			return false;
		}
		
		if(grid[row][col] == 1) {
			return true;
		}
		
		grid[row][col] = -1;
		
		boolean isDownValid = isValidPoint(row + 1,col,rows,cols);
		boolean isUpValid = isValidPoint(row - 1,col,rows,cols);
		boolean isLeftValid = isValidPoint(row,col - 1,rows,cols);
		boolean isRightValid = isValidPoint(row,col + 1,rows,cols);
		
		boolean isDownValid2 = true;
		boolean isUpValid2 = true;
		boolean isLeftValid2 = true;
		boolean isRightValid2 = true;
		
		if(isDownValid && grid[row + 1][col] == 0) {
			isDownValid2 = isDownValid2 && isClosedIsland(row + 1,col,rows,cols,grid);
		}
		
		if(isUpValid && grid[row + 1][col] == 0) {
			isUpValid2 = isUpValid2 && isClosedIsland(row - 1,col,rows,cols,grid);
		}
		
		if(isLeftValid && grid[row][col - 1] == 0) {
			isLeftValid2 = isLeftValid2 && isClosedIsland(row,col - 1,rows,cols,grid);
		}
		
		if(isRightValid && grid[row][col + 1] == 0) {
			isRightValid2 = isRightValid2 && isClosedIsland(row,col + 1,rows,cols,grid);
		}
		
		return isLeftValid2 && isDownValid2 && isRightValid2 && isUpValid2;
	}
	
	private boolean isValidPoint(int row, int col, int rows, int cols) {
		if(row < 0 || row >= rows || col < 0 || col >= cols) {
			return false;
		}
		
		
		return true;
	}
	
}
