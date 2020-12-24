package edu.stonybrook.pnarendra.hard;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
	
	public int oddEvenJumps(int[] A) {
		int len = A.length;
        boolean[] higher = new boolean[len];
        boolean[] lower = new boolean[len];
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        higher[len - 1] = true;
        lower[len - 1] = true;
        treeMap.put(A[len - 1], len - 1);
        int count = 1;
        for(int i = len-2; i>= 0; --i) {
        	Map.Entry higher_key_value_pair = treeMap.ceilingEntry(A[i]);
        	Map.Entry lower_key_value_pair = treeMap.floorEntry(A[i]);
        	
        	if(higher_key_value_pair != null) {
        		higher[i] = lower[(int)higher_key_value_pair.getValue()];
        	}
        	
        	if(lower_key_value_pair != null) {
        		lower[i] = higher[(int)lower_key_value_pair.getValue()];
        	}
        	
        	if(higher[i]) {
        		count++;
        	}
        	treeMap.put(A[i], i);
        }
        return count;
        
    }

}
