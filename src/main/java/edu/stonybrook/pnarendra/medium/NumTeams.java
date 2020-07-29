package edu.stonybrook.pnarendra.medium;

// 1395
// https://leetcode.com/problems/count-number-of-teams/

public class NumTeams {
	public int numTeams(int[] rating) {
        if(rating.length < 3) {
        	return 0;
        }else {
        	int count = 0;
        	int len = rating.length;
        	for(int i = 0; i <= rating.length - 3; i++) {
        		for(int j = i + 1; j <= rating.length - 2; j++) {
        			if(rating[j] < rating[i]) {
        				continue;
        			}else {
        				for(int k = j + 1; k <= rating.length - 1;k++) {
        					if(rating[k] < rating[j]) {
        						continue;
        					}else {
        						count += 1;
        					}
        				}
        			}
        		}
        	}
        	for(int i = 0; i < rating.length / 2; i++)
        	{
        	    int temp = rating[i];
        	    rating[i] = rating[rating.length - i - 1];
        	    rating[rating.length - i - 1] = temp;
        	}
        	for(int i = 0; i <= rating.length - 3; i++) {
        		for(int j = i + 1; j <= rating.length - 2; j++) {
        			if(rating[j] < rating[i]) {
        				continue;
        			}else {
        				for(int k = j + 1; k <= rating.length - 1;k++) {
        					if(rating[k] < rating[j]) {
        						continue;
        					}else {
        						count += 1;
        					}
        				}
        			}
        		}
        	}
        	return count;
        }
        
    }

}
