package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RussianDollEnvelopes {
	
	public int maxEnvelopes(int[][] envelopes) {
        List<int[]> list = new ArrayList<int[]>();
        Map<Integer, Integer> hashMap = new HashMap <Integer, Integer>();
        Map<Integer, int[]> lastEntry = new HashMap <Integer, int[]>();
        for(int[] envelope : envelopes) {
        	list.add(envelope);
        }
        int g = calculate(list,hashMap,lastEntry);
        return g < 0 ? 0 : g;
    }
	
	private int calculate(List<int[]> list, Map<Integer, Integer> hashmap, Map<Integer, int[]> lastEntry) {
		if(list.size() == 1) {
			int h = list.hashCode();
			if(!hashmap.containsKey(h)) {
				hashmap.put(h, 1);
				lastEntry.put(h, list.get(0));
				
			}
			return hashmap.get(h);
		}else {
			int h = list.hashCode();
			if(hashmap.containsKey(h)) {
				return hashmap.get(h);
			}else {
				int max = Integer.MIN_VALUE;
				int[] tempLastFit = new int[2];
				boolean foundAFit = false;
				int size = list.size();
				int hash = list.hashCode();
				for(int i = 0; i < size; i++) {
					int[] t = list.remove(i);
					List<int[]> f = new ArrayList<int[]>(list);
					int tempH = f.hashCode();
					int temp = calculate(f,hashmap,lastEntry);
					if(canFit(lastEntry.get(tempH),t)) {
						if(temp + 1 > max) {
							max = temp + 1;
							tempLastFit = t;
							foundAFit = true;
						}
					}else {
						// cannot fit
						if(temp > max) {
							max = temp;
							tempLastFit = lastEntry.get(tempH);
						}
					}
					list.add(i, t);
				}
				if(!foundAFit) {
					lastEntry.put(hash, tempLastFit);
					hashmap.put(hash, max);
				}else {
					lastEntry.put(hash, tempLastFit);
					hashmap.put(hash, max);
				}
				return hashmap.get(hash);
			}
		}
		
		
	}
	
	private boolean canFit(int[] lastFit, int[] newFit) {
		if(lastFit[0] < newFit[0] && lastFit[1] < newFit[1]) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		RussianDollEnvelopes a = new RussianDollEnvelopes();
		System.out.println(a.maxEnvelopes(new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}}));
	}

}
