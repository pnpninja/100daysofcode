package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
//	class Cell{
//		int x;
//		int y;
//		Integer difference;
//		
//		public Cell(int x, int y, int difference) {
//			this.x = x;
//			this.y = y;
//			this.difference = difference;
//		}
//	}
//	 int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//	public int minimumEffortPath(int[][] heights) {
//        int row = heights.length;
//        int col =heights[0].length;
//        int[][] differenceMatrix = new int[row][col];
//        for(int[] arr : differenceMatrix) {
//        	Arrays.fill(arr, Integer.MAX_VALUE);
//        }
//        differenceMatrix[0][0] = 0;
//        boolean[][] visited = new boolean[row][col];
//        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
//			@Override
//			public int compare(Cell o1, Cell o2) {
//				return o1.difference.compareTo(o2.difference);
//			}
//		});
//        pq.add(new Cell(0,0,new Integer(0)));
//        while(!pq.isEmpty()) {
//        	Cell cell = pq.poll();
//        	visited[cell.x][cell.y] = true;
//        	if(cell.x == row - 1 && cell.y == col - 1) {
//        		return cell.difference;
//        	}
//        	for(int[] direction : directions) {
//        		int adjacentX = cell.x + direction[0];
//        		int adjacentY = cell.y + direction[1];
//        		if(isValidCell(adjacentX,adjacentY,row,col) && !visited[adjacentX][adjacentY]) {
//        			int currentDifference = Math.abs(heights[cell.x][cell.y] - heights[adjacentX][adjacentY]);
//        			int maxDifference = Math.max(currentDifference, cell.difference);
//        			differenceMatrix[adjacentX][adjacentY] = Math.min(differenceMatrix[adjacentX][adjacentY], maxDifference);
//        			pq.add(new Cell(adjacentX,adjacentY,maxDifference));
//        		}
//        	}
//        	
//        }
//        return differenceMatrix[row - 1][col - 1];
//    }

   

    /*int backtrack(int x, int y, int[][] heights, int row, int col, int maxDifference) {
        if (x == row - 1 && y == col - 1) {
            maxSoFar = Math.min(maxSoFar, maxDifference);
            return maxDifference;
        }
        int currentHeight = heights[x][y];
        heights[x][y] = 0;
        int minEffort = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int adjacentX = x + directions[i][0];
            int adjacentY = y + directions[i][1];
            if (isValidCell(adjacentX, adjacentY, row, col) && heights[adjacentX][adjacentY] != 0) {
                int currentDifference = Math.abs(heights[adjacentX][adjacentY] - currentHeight);
                int maxCurrentDifference = Math.max(maxDifference, currentDifference);
                if (maxCurrentDifference < maxSoFar) {
                    int result = backtrack(adjacentX, adjacentY, heights, row, col, maxCurrentDifference);
                    minEffort = Math.min(minEffort, result);
                }
            }
        }
        heights[x][y] = currentHeight;
        return minEffort;
    }
    */
	public int minimumEffortPath(int[][] heights) {
		int l = 0, r = 1000001;
		while(l < r) {
			int limit = (l + r)/2;
			if(isGood(heights,limit)) {
				r = limit;
			}else {
				l = limit + 1;
			}
		}
		return l;
		
	}
	
	public boolean isGood(int[][] heights, int limit) {
		int row = heights.length;
		int col = heights[0].length;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[]{0,0});
		int[][] dirs = new int[][] {{1,0},{-1,0},{0,-1},{0,1}};
		boolean[][] visited = new boolean[row][col];
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			if(x == row - 1 && y == col - 1) {
				return true;
			}
			
			for(int[] dir : dirs) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				if(isValidCell(nx, ny, row, col) && !visited[nx][ny]) {
					int curDif = Math.abs(heights[nx][ny] - heights[x][y]);
					if(curDif <= limit) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
					}
				}
			}
			
		}
		return false;
		
	}
	

    boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new PathWithMinimumEffort().minimumEffortPath(new int[][]{{8,3,2,5,2,10,7,1,8,9},{1,4,9,1,10,2,4,10,3,5},{4,10,10,3,6,1,3,9,8,8},{4,4,6,10,10,10,2,10,8,8},{9,10,2,4,1,2,2,6,5,7},{2,9,2,6,1,4,7,6,10,9},{8,8,2,10,8,2,3,9,5,3},{2,10,9,3,5,1,7,4,5,6},{2,3,9,2,5,10,2,7,1,8},{9,10,4,10,7,4,9,3,1,6}}));
	}

}
