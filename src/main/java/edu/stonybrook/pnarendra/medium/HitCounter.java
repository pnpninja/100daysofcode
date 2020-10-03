package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HitCounter {
	
	LinkedList<Integer> counts = new LinkedList<>();
    int currTimestamp = 0;
    int sum = 0;
    /** Initialize your data structure here. */
    public HitCounter() {
        sum = 0;
        currTimestamp = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        adjust(timestamp);
        counts.set(0,counts.get(0) + 1);
        sum += 1;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        adjust(timestamp);
        return sum;
    }
    
    private void adjust(int timestamp){
        if((timestamp - currTimestamp) > 300){
            counts.clear();
            currTimestamp = timestamp - 1;
            sum = 0;
        }
        while(currTimestamp < timestamp) {
            counts.addFirst(0);
            currTimestamp++;
        }
        while(counts.size() > 300) {
            int val = counts.removeLast();
            sum = sum - val;
        }
    }

}
