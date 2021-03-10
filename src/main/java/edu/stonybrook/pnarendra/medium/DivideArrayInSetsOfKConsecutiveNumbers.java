package edu.stonybrook.pnarendra.medium;

import java.util.Map;
import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {
	
	public boolean isPossibleDivide(int[] hand, int W) {
        Map<Integer, Integer> handMap = new TreeMap<Integer, Integer>();
        for(int num : hand) {
        	handMap.put(num, handMap.getOrDefault(num, 0) + 1);
        }
        for(int num : handMap.keySet()) {
        	if(handMap.get(num) > 0) {
        		for(int i = W - 1; i >= 0; i--) {
        			if(handMap.getOrDefault(num+i, 0) < handMap.get(num)) {
        				return false;
        			}
        			handMap.put(num+i, handMap.get(num+i) - handMap.get(num));
        		}
        	}
        }
        return true;
    }

}
