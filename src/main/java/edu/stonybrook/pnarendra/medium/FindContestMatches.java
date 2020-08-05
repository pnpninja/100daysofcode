package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

// 544
// https://leetcode.com/problems/output-contest-matches/
public class FindContestMatches {
	
	public String findContestMatch(int n) {
		
        //Create list
		List<String> list = new ArrayList<String>();
		for(int i = 1; i <= n; i++) {
			list.add(Integer.toString(i));
		}
		
		int i = n;
		while(i  >  0) {
			// For each iteration, let's merge with second half;
			for(int j = 0; j < i/2; j++) {
				String left = list.get(j);
				String right = list.get(i - 1 - j);
				left = "("+left+","+right+")";
				list.set(j, left);
				list.remove(i - 1 - j);
			}
			i = i / 2;
		}
		return list.get(0);
    }
	

}
