package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {
	
	ArrayList<Integer>[] graph;
	int[] lowTimes;
	int visitedTimes[];
	boolean[] visited;
	int time;
	List<List<Integer>> criticalConnections;
	
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //Build Graph
		this.graph = new ArrayList[n];
		for(int i = 0; i < n;i++) {
			this.graph[i] = new ArrayList<Integer>();
		}
		
		for(List<Integer> connection : connections) {
			int a = connection.get(0);
			int b = connection.get(1);
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//init data structures
		this.lowTimes = new int[n];
		this.visitedTimes = new int[n];
		this.visited = new boolean[n];
		this.time = 0;
		this.criticalConnections = new ArrayList<List<Integer>>();
		this.dfs(0, -1);
		return this.criticalConnections;
		
		
    }
	
	private void dfs(int currentNode, int parentNode) {
		this.visited[currentNode] = true;
		this.visitedTimes[currentNode] = this.lowTimes[currentNode] = this.time++;
		for(int neighbor : this.graph[currentNode]) {
			if(neighbor == parentNode) continue;
			if(!this.visited[neighbor]) {
				dfs(neighbor, currentNode);
				this.lowTimes[currentNode] = Math.min(this.lowTimes[currentNode], this.lowTimes[neighbor]);
				if(this.visitedTimes[currentNode] < this.lowTimes[neighbor]) {
					//add critical connection
					this.criticalConnections.add(Arrays.asList(currentNode, neighbor));
				}
			}else {
				this.lowTimes[currentNode] = Math.min(this.lowTimes[currentNode], this.visitedTimes[neighbor]);
			}
		}
	}

}
