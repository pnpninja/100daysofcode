package edu.stonybrook.pnarendra.easy;

// 169
// https://leetcode.com/problems/majority-element/
public class MajorityElement {
	
	public int majorityElement(int[] nums) {
        int count = 0;
        Integer cand = null;
        for(int num : nums) {
        	if(count == 0) {
        		cand = num;
        	}
        	
        	count += num == cand ? 1: -1;
        }
        return cand;
    }

}
