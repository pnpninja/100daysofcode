package edu.stonybrook.pnarendra.solutions;

public class Mathworks_MathCodingPuzzle {
	
	public static int minNum(int A, int K, int P) {
		if(K <= A && P > 0) {
			return -1;
		}
		return P/(K-A) + 1;
	}

}
