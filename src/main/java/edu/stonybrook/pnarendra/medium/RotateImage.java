package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RotateImage {
	public static void rotate(int[][] matrix) {
        //Lets print circular
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		int r = 0;
		int n = matrix.length;
		while(left < right) {
			for(int i = left; i < right;i++) {
				//rotate one pixel
				int temp = matrix[r][i];
				int temp2 = matrix[i][n-1-r];
				int temp3 = matrix[n-1-r][n-1-i];
				int temp4 = matrix[n-1-i][r];
				matrix[r][i] = temp4;
				matrix[i][n-1-r] = temp;
				matrix[n-1-r][n-1-i] = temp2;
				matrix[n-1-i][r] = temp3;
			}
			left++;
			right--;
			r++;
		}
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}
