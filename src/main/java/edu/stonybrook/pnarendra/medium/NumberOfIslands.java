package edu.stonybrook.pnarendra.medium;

public class NumberOfIslands {
	
	public int numIslands(char[][] grid) {
        int count = 0;
        int numRows = grid.length;
        int numCols = grid.length == 0 ? 0 : grid[0].length;
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == '1') {
        			count++;
        			bfs(grid,i,j,numRows, numCols);
        		}
        	}
        }
        return count;
    }	
	
	private void bfs(char[][] grid, int row, int col, int rows, int cols) {
		if(isInsideGrid(row,col,rows,cols) && grid[row][col] == '1') {
			grid[row][col] = '2';
			bfs(grid, row - 1, col, rows, cols);
			bfs(grid, row + 1, col, rows, cols);
			bfs(grid, row, col - 1, rows, cols);
			bfs(grid, row, col + 1, rows, cols);
			return;
		}else {
			return;
		}
	}
	
	private boolean isInsideGrid(int row, int col, int numRows, int numCols) {
		if(row >= 0 && row < numRows && col >= 0 && col < numCols) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		//char[][] grid = grid = new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		char[][] grid = grid = new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(new NumberOfIslands().numIslands(grid));
 	}

}
