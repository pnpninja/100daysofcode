package edu.stonybrook.pnarendra.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Datum{
	public int key;
	public int score;
	
	public Datum(int key, int score) {
		this.key = key;
		this.score = score;
	}
	
	public void incrementScore(int score) {
		this.score+=score;
	}
}

class DatumComparator implements Comparator<Datum>{

	@Override
	public int compare(Datum o1, Datum o2) {
		if(o1.score < o2.score) {
			return 1;
		}else if(o1.score == o2.score) {
			return 0;
		}else {
			return -1;
		}
	}
	
}
class Leaderboard {

	Map<Integer, Datum> map;
	PriorityQueue<Datum> heap;
    public Leaderboard() {
        this.map = new HashMap<Integer, Datum>();
        this.heap = new PriorityQueue<Datum>(new DatumComparator());
        
    }
    
    public void addScore(int playerId, int score) {
        if(map.containsKey(playerId)) {
        	Datum player = this.map.get(playerId);
        	this.heap.remove(player);
        	player.incrementScore(score);
        	this.heap.add(player);
        	this.map.put(playerId, player);
        }else {
        	Datum player = new Datum(playerId,score);
        	this.map.put(playerId, player);
        	this.heap.add(player);
        }
    }
    
    public int top(int K) {
        int size = Math.min(K, this.heap.size());
        Queue<Datum> queue = new LinkedList<Datum>();
        int score = 0;
        while(size > 0) {
        	Datum temp = this.heap.poll();
        	score+=temp.score;
        	queue.add(temp);
        	size--;
        }
        while(!queue.isEmpty()) {
        	this.heap.add(queue.poll());
        }
        return score;
    }
    
    public void reset(int playerId) {
        if(map.containsKey(playerId)) {
        	Datum ref = this.map.get(playerId);
        	this.heap.remove(ref);
        	this.map.remove(playerId);
        }
    }
}
