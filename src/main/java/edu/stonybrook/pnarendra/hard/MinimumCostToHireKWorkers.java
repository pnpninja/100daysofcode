package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Worker{
	int wage;
	int quality;
	double ratio;
	
	public Worker(int wage, int quality) {
		this.wage = wage;
		this.quality = quality;
		this.ratio = (double)wage/quality;
	}
	
}
public class MinimumCostToHireKWorkers {
	
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Worker> workers = new ArrayList<Worker>();
        for(int i = 0; i < quality.length;i++) {
        	workers.add(new Worker(wage[i],quality[i]));
        }
        
        Collections.sort(workers,(a,b) -> Double.compare(a.ratio, b.ratio));
        
        PriorityQueue<Worker> maxHeap = new PriorityQueue<Worker>((a,b) -> b.quality - a.quality);
        double totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        for(Worker worker : workers) {
        	maxHeap.offer(worker);
        	totalQuality+=worker.quality;
        	
        	if(maxHeap.size() > K) {
        		totalQuality-=maxHeap.poll().quality;
        	}
        	
        	if(maxHeap.size() == K) {
        		minCost = Math.min(minCost, totalQuality*worker.ratio);
        	}
        }
        return minCost;
        
    }

}
