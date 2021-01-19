package edu.stonybrook.pnarendra.medium;

public class RandomPickWithWeight {
	
	private int[] prefixSum;
	int totalSum;
	
	public RandomPickWithWeight(int[] w) {
		this.prefixSum = new int[w.length];
        this.totalSum = 0;
        for(int i = 0; i < prefixSum.length; i++) {
        	this.totalSum+=w[i];
        	this.prefixSum[i] = this.totalSum;
        }
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        for(; i < this.prefixSum.length; i++) {
        	if(target < this.prefixSum[i]) {
        		return i;
        	}
        }
        return i-1;
    }

}
