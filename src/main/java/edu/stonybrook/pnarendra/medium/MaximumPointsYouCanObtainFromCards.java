package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

public class MaximumPointsYouCanObtainFromCards {	
	public int maxScore(int[] cardPoints, int k) {
		int max = 0, sum = 0;
        for(int i = 0; i<k;i++) sum += cardPoints[i];
        
        max = sum;
        for(int i = 1; i<=k; i++){
            sum = sum + cardPoints[cardPoints.length -i] - cardPoints[k -i];
            max = Math.max(max, sum);
        }
        
        return max;
    }

	
	public static void main(String[] args) {
		System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[] {1,2,3,4,5,6,1}, 3));
	}

}
