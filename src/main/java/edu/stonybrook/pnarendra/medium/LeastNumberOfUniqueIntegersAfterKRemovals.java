package edu.stonybrook.pnarendra.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Object {
	int num;
	int count;
}

public class LeastNumberOfUniqueIntegersAfterKRemovals {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Object> pq = new PriorityQueue<>(new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return o1.count - o2.count;
			}

		});
		for (int key : map.keySet()) {
			Object newObj = new Object();
			newObj.num = key;
			newObj.count = map.get(key);
			pq.add(newObj);
		}

		while (k > 0) {
			Object t = pq.peek();
			t.count--;
			if (t.count == 0) {
				pq.poll();
			}
			k--;
		}
		return pq.size();
	}
	

}
