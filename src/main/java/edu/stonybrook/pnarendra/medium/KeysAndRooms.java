package edu.stonybrook.pnarendra.medium;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while(!queue.isEmpty()) {
        	int loc = queue.poll();
        	if(visited[loc] == true) {
        		continue;
        	}else {
        		visited[loc] = true;
        		for(int pos : rooms.get(loc)) {
        			queue.add(pos);
        		}
        	}
        }
        for(int i = 0; i < len; i++) {
        	if(visited[i] == false) {
        		return false;
        	}
        }
        return true;
        
    }

}
