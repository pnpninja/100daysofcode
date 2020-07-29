package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 1409
// https://leetcode.com/problems/queries-on-a-permutation-with-key
public class ProcessQueries {
	public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= m; i++) {
        	list.add(i);
        }
        int[] answers = new int[queries.length];
        int temp;
        for(int i = 0; i < queries.length; i++) {
        	for(int j = 0; j < list.size(); j++) {
        		if(queries[i] == list.get(j)) {
        			temp = list.get(j);
        			list.remove(j);
        			list.add(0, temp);
        			answers[i] = temp;
        		}
        	}
        }
        return answers;
        
    }
}
