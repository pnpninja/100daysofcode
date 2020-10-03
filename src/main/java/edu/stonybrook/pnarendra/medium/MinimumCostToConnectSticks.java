package edu.stonybrook.pnarendra.medium;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumCostToConnectSticks {
	
	public static int connectSticks(int[] sticks) {
		int ans = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		});
		for(int stick : sticks) {
			queue.add(stick);
		}
		
		int i = 0, j = 0;
		while(queue.size()!=1) {
			i = queue.poll();
			if(queue.size() == 0) {
				return i;
			}else {
				j = queue.poll();
				queue.add(i + j);
				ans+=i+j;
			}
		}
		return ans;
        
        
    }
	
	public static void main(String[] args) {
		System.out.println(connectSticks(new int[] {2,4,3}));
	}
	
	
	

}
