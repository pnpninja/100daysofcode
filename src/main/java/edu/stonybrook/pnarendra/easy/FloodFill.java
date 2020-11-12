package edu.stonybrook.pnarendra.easy;

import java.util.LinkedList;

import javafx.util.Pair;
import sun.misc.Queue;

public class FloodFill {
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer,Integer>>();
        image[sr][sc] = -newColor;
        Pair<Integer,Integer> pt = new Pair<Integer, Integer>(sr, sc);
        queue.add(pt);
        while(!queue.isEmpty()) {
        	Pair<Integer,Integer> nextPt = queue.poll();
        	int r = nextPt.getKey();
        	int c = nextPt.getValue();
        	if(isValid(r+1,c,rows,cols) && image[r+1][c] == color) {
        		image[r+1][c] = -newColor;
        		Pair<Integer,Integer> l1 = new Pair<Integer, Integer>(r+1, c);
        		queue.add(l1);
        	}
        	if(isValid(r-1,c,rows,cols) && image[r-1][c] == color) {
        		image[r-1][c] = -newColor;
        		Pair<Integer,Integer> l1 = new Pair<Integer, Integer>(r-1, c);
        		queue.add(l1);
        	}
        	if(isValid(r,c+1,rows,cols) && image[r][c+1] == color) {
        		image[r][c+1] = -newColor;
        		Pair<Integer,Integer> l1 = new Pair<Integer, Integer>(r, c+1);
        		queue.add(l1);
        	}
        	if(isValid(r,c-1,rows,cols) && image[r][c-1] == color) {
        		image[r][c-1] = -newColor;
        		Pair<Integer,Integer> l1 = new Pair<Integer, Integer>(r, c-1);
        		queue.add(l1);
        	}
        	
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(image[i][j] == -newColor){
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
	
	public boolean isValid(int r, int c, int rows, int cols) {
		if(r < 0 || r >= rows || c < 0 || c >= cols) {
			return false;
		}
		return true;
	}

}
