package edu.stonybrook.pnarendra.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
	
	public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length;i++) {
        	map.put(stones[i], new HashSet<Integer>());
        }
        
        map.get(0).add(0);
        for(int i = 0; i < stones.length; i++) {
        	for(int k : map.get(stones[i])) {
        		for(int j = k-1; j <= k+1; j++) {
        			if(j > 0  && map.containsKey(stones[i]+j)) {
        				map.get(stones[i]+j).add(j);
        			}
        		}
        	}
        }
        return map.get(stones[stones.length - 1]).size()>0;
    }

}
