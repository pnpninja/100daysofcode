package edu.stonybrook.pnarendra.hard;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ListNode {
	public int key;
	public int value;
	public int nosAccesses;
	public int lastAccessTime;
}

class ListNodeComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode o1, ListNode o2) {
		if (o1.nosAccesses < o2.nosAccesses) {
			return -1;
		} else if (o1.nosAccesses > o2.nosAccesses) {
			return 1;
		} else {
			if(o1.lastAccessTime < o2.lastAccessTime) {
				return -1;
			}else if(o2.lastAccessTime < o1.lastAccessTime) {
				return 1;
			}else {
				return 0;
			}
			
		}
	}

}

public class LFUCache {

	int currentCapacity;
	int maxCapacity;
	PriorityQueue<ListNode> minHeap;
	Map<Integer, ListNode> map;
	int globalClock;

	public LFUCache(int capacity) {
		this.maxCapacity = capacity;
		this.currentCapacity = 0;
		this.map = new HashMap<Integer, ListNode>();
		this.minHeap = new PriorityQueue<ListNode>(new ListNodeComparator());
		this.globalClock = 0;

	}

	public int get(int key) {
		if (this.map.containsKey(key)) {
			ListNode obj = this.map.get(key);
			this.minHeap.remove(obj);
			obj.nosAccesses++;
			obj.lastAccessTime = ++this.globalClock;
			this.minHeap.add(obj);
			return obj.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if(this.maxCapacity == 0) {
			return;
		}
		if (this.currentCapacity < this.maxCapacity) {
			if (this.map.containsKey(key)) {
				ListNode obj = this.map.get(key);
				this.minHeap.remove(obj);
				this.map.remove(key);
				this.currentCapacity = this.currentCapacity - 1;
				ListNode obj2 = new ListNode();
				obj2.key = key;
				obj2.value = value;
				obj2.nosAccesses = obj.nosAccesses + 1;
				obj2.lastAccessTime = ++this.globalClock;
				this.minHeap.add(obj2);
				this.map.put(key, obj2);
				this.currentCapacity = this.currentCapacity + 1;		
			}else {
				ListNode obj = new ListNode();
				obj.key = key;
				obj.value = value;
				obj.nosAccesses = 0;
				obj.lastAccessTime = ++this.globalClock;
				this.minHeap.add(obj);
				this.map.put(key, obj);
				this.currentCapacity = this.currentCapacity + 1;
			}		
		} else {
			ListNode obj = null;
			if (this.map.containsKey(key)) {
				obj = this.map.get(key);
				this.map.remove(obj.key);
				this.minHeap.remove(obj);
				obj.key = key;
				obj.value = value;
				obj.nosAccesses = obj.nosAccesses + 1;
				obj.lastAccessTime = ++this.globalClock;
				this.minHeap.add(obj);
				this.map.put(key, obj);
			} else {
				obj = this.minHeap.poll();
				this.map.remove(obj.key);
				obj.key = key;
				obj.value = value;
				obj.nosAccesses = 0;
				obj.lastAccessTime = ++this.globalClock;
				this.minHeap.add(obj);
				this.map.put(key, obj);
			}
			
		}
	}

	public static void main(String[] args) {
//		LFUCache lfuCache = new LFUCache(2);
//		lfuCache.put(1, 1);
//		lfuCache.put(2, 2);
//		int ans = lfuCache.get(1);
//		lfuCache.put(3, 3);
//		ans = lfuCache.get(2);
//		ans = lfuCache.get(3);
//		lfuCache.put(4, 4);
//		ans = lfuCache.get(1);
//		ans = lfuCache.get(3);
//		ans = lfuCache.get(4);
		
//		lfuCache.put(2,1);
//		lfuCache.put(1,1);
//		lfuCache.put(2,3);
//		lfuCache.put(4,1);
//		int ans = lfuCache.get(1);
//		ans = lfuCache.get(2);
		
		LFUCache lfuCache = new LFUCache(3);
		lfuCache.put(1,1);
		lfuCache.put(2,2);
		lfuCache.put(3,3);
		lfuCache.put(4,4);
		int ans = lfuCache.get(4);
		ans = lfuCache.get(3);
		ans = lfuCache.get(2);
		ans = lfuCache.get(1);
		lfuCache.put(5,5);
		ans = lfuCache.get(1);
		ans = lfuCache.get(2);
		ans = lfuCache.get(3);
		ans = lfuCache.get(4);
		ans = lfuCache.get(5);
	}

}
