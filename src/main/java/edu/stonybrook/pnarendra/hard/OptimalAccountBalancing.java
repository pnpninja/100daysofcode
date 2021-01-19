package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class OptimalAccountBalancing {
	
	public int minTransfers(int[][] transactions) {
		
		Map<Integer, Integer> balance = new HashMap<Integer, Integer>();
	
		for(int[] transaction : transactions) {
			balance.put(transaction[0], balance.getOrDefault(transaction[0],0)+transaction[2]);
			balance.put(transaction[1], balance.getOrDefault(transaction[1],0)-transaction[2]);
		}
		
		List<Integer> bal = new ArrayList<Integer>();
		for(Map.Entry<Integer,Integer> entry : balance.entrySet()) {
			int balT = entry.getValue();
			if(balT != 0) {
				bal.add(balT);
			}
		}
		
		return dfs(0,bal);
        
    }
	
	public int dfs(int index, List<Integer> bal) {
		if(index == bal.size()) {
			return 0;
		}
		int cur = bal.get(index);
		if(cur == 0) {
			return dfs(index + 1, bal);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = index + 1; i < bal.size();i++) {
			int next = bal.get(i);
			if(cur * next < 0) {
				bal.set(i, cur + next);
				min = Math.min(min, 1 + dfs(index+1,bal));
				bal.set(i, next);
				if(cur+next == 0) break;
			}
		}
		return min;
	}
	
	
	
	public static void main(String[] args) {
		//System.out.println(new OptimalAccountBalancing().minTransfers(new int[][] {{1,5,8},{8,9,8},{2,3,9},{4,3,1}}));
		System.out.println(new OptimalAccountBalancing().minTransfers(new int[][] {{1,2,3},{1,3,3},{6,4,1},{5,4,4}}));
	}

}
