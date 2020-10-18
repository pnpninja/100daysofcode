package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
	
	public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        intervals = sortIntervals(intervals);
        for(int[] interval : intervals) {
        	if(mergedIntervals.isEmpty()) {
        		mergedIntervals.add(interval);
        	}else {
        		int[] lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
        		if(lastInterval[1] > interval[0]) {
        			lastInterval[1] = Math.max(lastInterval[1], interval[1]);
        			mergedIntervals.remove(mergedIntervals.size() - 1);
        			mergedIntervals.add(mergedIntervals.size() - 1, lastInterval);
        		}else {
        			mergedIntervals.add(interval);
        		}
        	}
        }
        
        int[][] mergedIntervalsAnswer = new int[mergedIntervals.size()][2];
        for(int i = 0; i < mergedIntervals.size(); i++) {
        	mergedIntervalsAnswer[i] = mergedIntervals.get(i);
        }
        return mergedIntervalsAnswer;
    }
	
	private int[][] sortIntervals(int[][] intervals){
		PriorityQueue<int[]> mergedIntervals = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return new Integer(o1[0]).compareTo(o2[0]);
			}
		});
		for(int[] interval : intervals) {
			mergedIntervals.add(interval);
		}
		int i = 0;
		while(!mergedIntervals.isEmpty()) {
			intervals[i++] = mergedIntervals.poll();
		}
		return intervals;
	}

}
