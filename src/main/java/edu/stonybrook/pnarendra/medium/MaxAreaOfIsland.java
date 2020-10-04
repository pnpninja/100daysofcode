package edu.stonybrook.pnarendra.medium;

public class MaxAreaOfIsland {
	
	public int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int max = 0;
        for(int row = 0; row < rows; row++) {
        	for(int col = 0; col < cols; col++) {
        		if(grid[row][col] > 0) {
        			max = Math.max(max, getMaxPath(grid, row, col, rows, cols));
        		}
        	}
        	
        }
        return max;
    }
	
	private int getMaxPath(int[][] grid, 
			int row, int col, int rows, int cols) {
		if(!canCheck(row,col,rows,cols,grid)) {
			return 0;
		}
		grid[row][col] = -grid[row][col];
		int left = getMaxPath(grid, row, col - 1, rows, cols);
		int right = getMaxPath(grid, row, col + 1, rows, cols);
		int up = getMaxPath(grid, row - 1, col, rows, cols);
		int down = getMaxPath(grid, row + 1, col, rows, cols);
		
		int maxPath = up+down+left+right;
		//grid[row][col] = -grid[row][col];
		return maxPath + 1;
	}
	
	private boolean isValid(int row, int col, int rows, int cols) {
		if(row >= 0 && row < rows && col >= 0 && col < cols) {
			return true;
		}
		return false;
	}
	
	private boolean canCheck(int row, int col, int rows, int cols, int[][] grid) {
		if(isValid(row,col,rows,cols)) {
			if(grid[row][col] > 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] mat = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(mat));

	}

}
