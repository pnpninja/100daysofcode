package edu.stonybrook.pnarendra.medium;

// 1381
/// https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class CustomStack {
	
	int[] array;
	int currentTop;
	int maxSize;
	
	public CustomStack(int maxSize) {
        this.array = new int[maxSize];
        this.maxSize = maxSize;
        this.currentTop = -1;
    }
    
    public void push(int x) {
        if(this.currentTop == this.maxSize - 1) {
        	return;
        }else {
        	this.array[++this.currentTop] = x;
        }
    }
    
    public int pop() {
        if(this.currentTop == -1) {
        	return this.currentTop;
        }else {
        	return this.array[this.currentTop--];
        }
    }
    
    public void increment(int k, int val) {
        int iteratorSize = this.maxSize < k ? this.maxSize : k;
        for(int i = 0; i < iteratorSize; i++) {
        	this.array[i] += val;
        }
    }

}
