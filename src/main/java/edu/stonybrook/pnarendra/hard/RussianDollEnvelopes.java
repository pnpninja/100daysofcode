package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class EnvelopeComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		if (o1[0] < o2[0]) {
			return -1;
		} else if (o1[0] == o2[0]) {
			if (o1[1] < o2[1]) {
				return -1;
			} else if (o1[1] == o2[1]) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}

}

public class RussianDollEnvelopes {

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0) {
			return 0;
		}
		Arrays.sort(envelopes, new EnvelopeComparator());
		int[] maxDepth = new int[envelopes.length];
		int answer = 1;
		Arrays.fill(maxDepth, 1);
		for (int i = 0; i < envelopes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]
						&& maxDepth[j] + 1 > maxDepth[i]) {
					maxDepth[i] = maxDepth[j] + 1;
				}

				if (answer < maxDepth[i]) {
					answer = maxDepth[i];
				}
			}
		}
		return answer;

	}
	
	public int maxEnvelopes2(int[][] envelopes) {
		if (envelopes.length == 0) {
			return 0;
		}
		Arrays.sort(envelopes, (a,b) ->  a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
		int n = envelopes.length;
		int[] sorted = new int[n];
		int last = 0;
		for(int i = 0; i < n; i++) {
			int lowerBound = Arrays.binarySearch(sorted, 0, last, envelopes[i][1]);
			if(lowerBound < 0) {
				lowerBound = -lowerBound - 1;
			}
			
			sorted[lowerBound] = envelopes[i][1];
			if(last == lowerBound) {
				last++;
			}
		}
		return last;
		
		

	}

//	private int calculate(List<int[]> list, Map<Integer, Integer> hashmap, Map<Integer, int[]> lastEntry) {
//		if(list.size() == 1) {
//			int h = list.hashCode();
//			if(!hashmap.containsKey(h)) {
//				hashmap.put(h, 1);
//				lastEntry.put(h, list.get(0));
//				
//			}
//			return hashmap.get(h);
//		}else {
//			int h = list.hashCode();
//			if(hashmap.containsKey(h)) {
//				return hashmap.get(h);
//			}else {
//				int max = Integer.MIN_VALUE;
//				int[] tempLastFit = new int[2];
//				boolean foundAFit = false;
//				int size = list.size();
//				int hash = list.hashCode();
//				for(int i = 0; i < size; i++) {
//					int[] t = list.remove(i);
//					List<int[]> f = new ArrayList<int[]>(list);
//					int tempH = f.hashCode();
//					int temp = calculate(f,hashmap,lastEntry);
//					if(canFit(lastEntry.get(tempH),t)) {
//						if(temp + 1 > max) {
//							max = temp + 1;
//							tempLastFit = t;
//							foundAFit = true;
//						}
//					}else {
//						// cannot fit
//						if(temp > max) {
//							max = temp;
//							tempLastFit = lastEntry.get(tempH);
//						}
//					}
//					list.add(i, t);
//				}
//				if(!foundAFit) {
//					lastEntry.put(hash, tempLastFit);
//					hashmap.put(hash, max);
//				}else {
//					lastEntry.put(hash, tempLastFit);
//					hashmap.put(hash, max);
//				}
//				return hashmap.get(hash);
//			}
//		}
//		
//		
//	}
//	
//	private boolean canFit(int[] lastFit, int[] newFit) {
//		if(lastFit[0] < newFit[0] && lastFit[1] < newFit[1]) {
//			return true;
//		}
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		RussianDollEnvelopes a = new RussianDollEnvelopes();
//		System.out.println(a.maxEnvelopes(new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}}));
//	}

}
