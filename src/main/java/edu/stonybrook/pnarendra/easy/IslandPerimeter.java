package edu.stonybrook.pnarendra.easy;

public class IslandPerimeter {
	
	public int islandPerimeter(int[][] grid) {
		int border = 0, up, down, left, right;
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == 1) {
					if(row == 0) up = 0;
					else {
						up = grid[row - 1][col];
					}
					
					if(col == 0) left = 0;
					else {
						left = grid[row][col - 1];
					}
					
					if(row == grid.length - 1) down = 0;
					else {
						down = grid[row + 1][col];
					}
					
					if(col == grid[0].length - 1) right = 0;
					else {
						right = grid[row][col + 1];
					}
					
					border+=4-(up+down+left+right);
				}
				
			}
		}
		return border;
    }

}
