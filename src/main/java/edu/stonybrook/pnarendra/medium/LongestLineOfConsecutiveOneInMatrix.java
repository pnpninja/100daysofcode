package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestLineOfConsecutiveOneInMatrix {
	
	int rows, cols;
	int[][] matrix;
	Map<String, Integer> map;
	public int longestLine(int[][] M) {
		if(M.length == 0) {
			return 0;
		}
        map = new HashMap<String, Integer>();
        rows = M.length;
        cols = M[0].length;
        matrix = M;
        int maxLen = 0;
        String[] dirs = {"UP","DOWN","LEFT","RITE","DIA1","DIA2"};
        for(int row = 0; row < rows; row++) {
        	for(int col = 0; col < cols; col++) {
        		for(String dir : dirs) {
        			maxLen = Math.max(maxLen, dfs(row,col,dir));
        		}
        	}
        }
        return maxLen;
    }
	
	private int dfs(int row, int col, String direction) {
		String key = prepareKey(row, col, direction);
		if(map.containsKey(key)) {
			return map.get(key);
		}else{
			if(isValid(row,col)) {
				if(matrix[row][col] == 0) {
					map.put(key,0);
					return 0;
				}else {
					switch(direction) {
					case "UP":  int U = dfs(row-1,col,"UP");
					 			 map.put(key, U+1);
					 			 return U+1;
					case "DOWN": int d = dfs(row+1,col,"DOWN");
								 map.put(key, d+1);
								 return d+1;
					case "RITE": int s = dfs(row, col+1,"RITE");
								 map.put(key, s+1);
								 return s+1;
					case "LEFT": int s2 = dfs(row, col-1,"LEFT");
					 			 map.put(key, s2+1);
					 			 return s2+1;
					case "DIA1": int d1 = dfs(row+1,col+1,"DIA1");
								 map.put(key, d1+1);
								 return d1+1;
					case "DIA2": int d2 = dfs(row-1,col+1,"DIA2");
								 map.put(key, d2+1);
								 return d2+1;
					default: return 0;
					}
				}
			}else {
				map.put(key,0);
				return 0;
			}
		}
	}
	
	
	
	private String prepareKey(int row, int col, String direction) {
		return Integer.toString(row)+","+Integer.toString(col)+","+direction;
	}
	
	private boolean isValid(int row, int col) {
		if(row < 0 || row >= rows || col < 0 || col >= cols) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		//int[][] matrix = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
		int[][] matrix = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
		System.out.println(new LongestLineOfConsecutiveOneInMatrix().longestLine(matrix));
	}

}
