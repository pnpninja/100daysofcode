package edu.stonybrook.pnarendra.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

class MinHeapComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
	
}

class MaxHeapComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}
	
}
public class MedianOfDataStream {
	
	class MedianFinder {

	    /** initialize your data structure here. */
		PriorityQueue<Integer> firstHalf;
		PriorityQueue<Integer> secondHalf;
		int firstHalfSize;
		int secondHalfSize;
		
	    public MedianFinder() {
	        this.firstHalf = new PriorityQueue<Integer>(new MaxHeapComparator());
	        this.secondHalf = new PriorityQueue<Integer>(new MinHeapComparator());
	        this.firstHalfSize = 0;
	        this.secondHalfSize = 0;
	    }
	    
	    public void addNum(int num) {
	        if(this.firstHalfSize == 0 && this.secondHalfSize == 0) {
	        	this.firstHalf.add(num);
	        	this.firstHalfSize++;
	        }else if(this.firstHalfSize == 1 && this.secondHalfSize == 0) {
	        	int topOfFirstHalf = this.firstHalf.poll();
	        	this.firstHalf.add(Math.min(topOfFirstHalf, num));
	        	this.secondHalf.add(Math.max(topOfFirstHalf, num));
	        	this.secondHalfSize++;
	        }else {
	        	int topOfFirstHalf = this.firstHalf.peek();
	        	int topOfSecondHalf = this.secondHalf.peek();
	        	if(topOfFirstHalf <= num && num <= topOfSecondHalf) {
	        		if(this.firstHalfSize == this.secondHalfSize) {
	        			this.firstHalf.add(num);
	        			this.firstHalfSize++;
	        		}else if(this.firstHalfSize > this.secondHalfSize) {
	        			this.secondHalf.add(num);
	        			this.secondHalfSize++;
	        		}else {
	        			this.firstHalf.add(num);
	        			this.firstHalfSize++;
	        		}
	        	}else if(num < topOfFirstHalf) {
	        		if(this.firstHalfSize < this.secondHalfSize) {
	        			this.firstHalf.add(num);
	        			this.firstHalfSize++;
	        		}else {
	        			topOfFirstHalf = this.firstHalf.poll();
	        			this.secondHalf.add(topOfFirstHalf);
	        			this.secondHalfSize++;
	        			this.firstHalf.add(num);
	        		}
	        	}else /* num > topOfFirstHalf */{
	        		if(this.secondHalfSize < this.firstHalfSize) {
	        			this.secondHalf.add(num);
	        			this.secondHalfSize++;
	        		}else {
	        			topOfSecondHalf = this.secondHalf.poll();
	        			this.firstHalf.add(topOfSecondHalf);
	        			this.firstHalfSize++;
	        			this.secondHalf.add(num);
	        		}
	        	}
	        }
	    }
	    
	    public double findMedian() {
	        if(this.firstHalfSize == 0 && this.secondHalfSize == 0) {
	        	return 0d;
	        }else if(this.firstHalfSize == 1 && this.secondHalfSize == 0) {
	        	return (double)this.firstHalf.peek();
	        }else if(this.firstHalfSize == this.secondHalfSize) {
	        	double sum = this.firstHalf.peek() + this.secondHalf.peek();
	        	return sum/2;
	        }else if(this.firstHalfSize > this.secondHalfSize) {
	        	return (double)this.firstHalf.peek();
	        }else {
	        	return (double)this.secondHalf.peek();
	        }
	    }
	}

}
