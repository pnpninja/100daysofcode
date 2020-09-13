package edu.stonybrook.pnarendra.solutions;

public class Robinhood_DiceTotalScore {
	
	int diceTotalScore(int a, int b, int c) {
		if(a == b && b == c) {
			return 1000 * a;
		}else if(a == b && b != c) {
			return 500 * a;
		}else if(b == c && c != a) {
			return 500 * b;
		}else if( a == c && b != c) {
			return 500 * c;
		}else {
			return 100 * Math.min(a, Math.min(b, c));
		}
	}

}
