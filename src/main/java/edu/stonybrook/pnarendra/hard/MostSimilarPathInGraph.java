package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostSimilarPathInGraph {
	List<List<Integer>> adjMatrix;
    String[] targetPath;
    int[][] visited;
    int[][] nextChoiceForMin;
    String[] names;
	public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
		
        this.names = names;
        this.targetPath = targetPath;
        this.visited = new int[names.length][targetPath.length];
        this.nextChoiceForMin = new int[names.length][targetPath.length];
        adjMatrix = new ArrayList<List<Integer>>();
        for(int[] a : visited) {
        	Arrays.fill(a, -1);
        }
        
        for(int i = 0; i < n; i++) {
        	adjMatrix.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < roads.length; i++) {
        	adjMatrix.get(roads[i][0]).add(roads[i][1]);
        	adjMatrix.get(roads[i][1]).add(roads[i][0]);
        }
        
        int minIdx = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < names.length; i++) {
        	int x = dfs(i,0);
        	if(x < res) {
        		res = x;
        		minIdx = i;
        	}
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        while(ans.size() < targetPath.length) {
        	ans.add(minIdx);
        	minIdx = nextChoiceForMin[minIdx][ans.size()-1];
        }
        
        return ans;
        
    }
	
	private int dfs(int nameIdx, int currPathIdx) {
		if(visited[nameIdx][currPathIdx] != -1) {
			return visited[nameIdx][currPathIdx];
		}
		
		int editDist = names[nameIdx].equals(targetPath[currPathIdx]) ? 0 : 1;
		
		if(currPathIdx == targetPath.length-1) {
			return editDist;
		}
		
		int min = Integer.MAX_VALUE;
		for(int neighbor : adjMatrix.get(nameIdx)) {
			int neighborCost = dfs(neighbor, currPathIdx + 1);
			if(neighborCost < min) {
				min = neighborCost;
				nextChoiceForMin[nameIdx][currPathIdx] = neighbor;
			}
		}
		
		editDist+=min;
		visited[nameIdx][currPathIdx] = editDist;
		return editDist;
	}

}
