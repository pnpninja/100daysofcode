package edu.stonybrook.pnarendra.medium;

import java.util.ArrayDeque;
import java.util.LinkedList;

import javafx.util.Pair;
import sun.misc.Queue;

public class RottingOranges {
	
	public int orangesRotting(int[][] grid){
        int freshOranges = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int iter = 0;
        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque<Pair<Integer,Integer>>();
        for(int row = 0; row < grid.length; row++) {
        	for(int col = 0; col < grid[0].length; col++) {
        		if(grid[row][col] == 1) {
        			freshOranges++;
        		}else if(grid[row][col] == 2) {
        			queue.add(new Pair<Integer, Integer>(row, col));
        		}
        	}
        }
        
        while(!queue.isEmpty()) {
        	ArrayDeque<Pair<Integer,Integer>> tempQueue = new ArrayDeque<Pair<Integer,Integer>>();
        	while(!queue.isEmpty()) {
        		Pair<Integer,Integer> rottenLoc = queue.pollFirst();
            	int r = rottenLoc.getKey();
            	int c = rottenLoc.getValue();
            	
            	if(isValidLoc(r+1,c,rows,cols) && grid[r+1][c] == 1) {
            		grid[r+1][c] = 2;
            		freshOranges--;
            		tempQueue.add(new Pair<Integer, Integer>(r+1, c));
            	}
            	if(isValidLoc(r-1,c,rows,cols) && grid[r-1][c] == 1) {
            		grid[r-1][c] = 2;
            		freshOranges--;
            		tempQueue.add(new Pair<Integer, Integer>(r-1, c));
            	}
            	if(isValidLoc(r,c+1,rows,cols) && grid[r][c+1] == 1) {
            		grid[r][c+1] = 2;
            		freshOranges--;
            		tempQueue.add(new Pair<Integer, Integer>(r, c+1));
            	}
            	if(isValidLoc(r,c-1,rows,cols) && grid[r][c-1] == 1) {
            		grid[r][c-1] = 2;
            		freshOranges--;
            		tempQueue.add(new Pair<Integer, Integer>(r, c-1));
            	}
        	}
        	if(!tempQueue.isEmpty()){
                iter++;
            }
        	queue = tempQueue;
       	 	
        }
        
        return freshOranges != 0 ? -1 : iter;
    }
	
	public boolean isValidLoc(int row, int col, int rows, int cols) {
		if(row < 0 || row >= rows || col < 0 || col >= cols) {
			return false;
		}
		return true;
	}

}
