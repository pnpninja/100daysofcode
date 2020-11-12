package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTree {
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		
        if(n < 2) {
        	List<Integer> answer = new ArrayList<Integer>();
        	for(int i = 0; i < n; i++) {
        		answer.add(i);
        	}
        	return answer;
        }
        
        List<Set<Integer>> neighbors = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	neighbors.add(new HashSet<Integer>());
        }
        
        for(int[] edge : edges) {
        	neighbors.get(edge[0]).add(edge[1]);
        	neighbors.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < n;i++) {
        	if(neighbors.get(i).size() == 1) {
        		leaves.add(i);
        	}
        }
       
        int remainingNodes = n;
        while(remainingNodes > 2) {
        	remainingNodes-=leaves.size();
        	List<Integer> newLeaves = new ArrayList<Integer>();
        	for(int leaf : leaves) {
        		for(int neighborLeaf : neighbors.get(leaf)) {
        			neighbors.get(neighborLeaf).remove(leaf);
        			if(neighbors.get(neighborLeaf).size() == 1) {
        				newLeaves.add(neighborLeaf);
        			}
        		}
        	}
        	leaves = newLeaves;
        }
        return leaves;
    }

}
