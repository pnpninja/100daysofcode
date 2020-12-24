package edu.stonybrook.pnarendra.medium;

public class SearchIn2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(true){
            if(row >= matrix.length || col < 0){
                break;
            }else if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

}
