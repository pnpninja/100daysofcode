package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

// 807
// https://leetcode.com/problems/max-increase-to-keep-city-skyline/
public class MaxIncreaseKeepingSkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int gridSize = grid.length;
        int[] maxHeightDir1 = new int[gridSize];
        int[] maxHeightDir2 = new int[gridSize];
        
        for(int i = 0; i < gridSize; i++) {
        	for(int j = 0; j < gridSize; j++) {
        		if(grid[i][j] > maxHeightDir1[i]) {
        			maxHeightDir1[i] = grid[i][j];
        		}
        		if(grid[i][j] > maxHeightDir2[j]) {
        			maxHeightDir2[j] = grid[i][j];
        		}
        	}
        }
        
        int sum = 0;
        for(int i = 0; i < gridSize; i++) {
        	for(int j = 0; j < gridSize; j++) {
        		sum += Math.min(maxHeightDir1[i], maxHeightDir2[j]) - grid[i][j];
        	}
        }
        return sum;
    }
	
}
