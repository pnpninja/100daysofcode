package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DataStreamAsDisjointIntervals {
	class SummaryRanges {

	    /** Initialize your data structure here. */
		TreeSet<Integer> numbers;
	    public SummaryRanges() {
	        this.numbers = new TreeSet<Integer>();
	    }
	    
	    public void addNum(int val) {
	        this.numbers.add(val);
	    }
	    
	    public int[][] getIntervals() {
	        List<int[]> answers = new ArrayList<int[]>();
	        Set<Integer> processed = new HashSet<Integer>();
	        
	        for(int num : numbers) {
	        	if(processed.contains(num)) {
	        		continue;
	        	}
	        	processed.add(num);
	        	int cur = num;
	        	while(numbers.contains(cur+1)) {
	        		cur++;
	        		processed.add(cur);
	        	}
	        	answers.add(new int[] {num,cur});
	        }
	        return answers.toArray(new int[answers.size()][2]);
	    }
	}
}
