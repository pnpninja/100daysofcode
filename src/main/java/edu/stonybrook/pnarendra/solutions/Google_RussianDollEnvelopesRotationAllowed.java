package edu.stonybrook.pnarendra.solutions;

import java.util.Arrays;


public class Google_RussianDollEnvelopesRotationAllowed {
	
	public int maxEnvelopes(int[][] envelopes) {
		//Sort the envelopes so that the smaller side is always length
		for(int i = 0; i < envelopes.length; i++) {
			if(envelopes[i][0] > envelopes[i][1]) {
				int temp = envelopes[i][0];
				envelopes[i][0] = envelopes[i][1];
				envelopes[i][1] = temp;
			}
		}
		
		Arrays.sort(envelopes, (a,b) ->  a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
		int n = envelopes.length;
		int[] sorted = new int[n];
		int last = 0;
		for(int i = 0; i < n; i++) {
			int lowerBound = Arrays.binarySearch(sorted, 0, last, envelopes[i][1]);
			if(lowerBound < 0) {
				lowerBound = -lowerBound - 1;
			}
			
			sorted[lowerBound] = envelopes[i][1];
			if(last == lowerBound) {
				last++;
			}
		}
		return last;
	}
	
	public static void main(String[] args) {
		
	}

}
