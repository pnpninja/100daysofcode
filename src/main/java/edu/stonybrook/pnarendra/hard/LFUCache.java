package edu.stonybrook.pnarendra.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {

    class ListNode{
    	int key;
    	int val;
    	int freq;
    	ListNode next;
    	ListNode prev;
    	
    	public ListNode(int key, int val, int freq) {
    		this.key = key;
    		this.val = val;
    		this.freq = freq;
    	}
    	
    	public ListNode(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    	 	
    }
    
    class DLinkedList{
    	ListNode head;
    	ListNode tail;
    	int size;
    	
    	public DLinkedList() {
    		this.head = new ListNode(0,0);
    		this.tail = new ListNode(0,0);
    		this.head.next = this.tail;
    		this.tail.prev = this.head;
    		this.size = 0;
    	}
    	
    	public void add(ListNode node) {
    		node.prev = tail.prev;
    		node.next = tail;
    		tail.prev.next = node;
    		tail.prev = node;
    		this.size++;  		
    	}
    	
    	public void remove(ListNode node) {
    		node.next.prev = node.prev;
        	node.prev.next = node.next;
        	this.size--;
   		
    	}
    	
    	public ListNode poll() {
    		if(this.size >= 1) {
    			ListNode node = head.next;
        		remove(node);
        		return node;
    		}
    		return null;    		
    	}
    	
    	public int size() {
    		return this.size;
    	}
    	
    	public boolean isEmpty() {
    		return this.size == 0;
    	}
    	
    	
    	
    }
    
    Map<Integer, ListNode> kvMap;
	TreeMap<Integer, DLinkedList> sameFreqMap;
	int capacity;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.kvMap = new HashMap<Integer, ListNode>();
		this.sameFreqMap = new TreeMap<Integer, DLinkedList>();
	}
	
	public int get(int key) {
       if(this.capacity < 1) {
    	   return -1;
       }
       
       ListNode v = kvMap.get(key);
       if(v == null) {
    	   return -1;
       }else {
    	   update(v);
    	   return v.val;   	   
       }
    }
	
	public void put(int key, int value) {
		if(this.capacity < 1) {
			return;
		}
		
		ListNode v = kvMap.get(key);
		if(v == null) {
			if(kvMap.size() == this.capacity) {
				//Remove the least frequently used
				int lowestFreq = sameFreqMap.firstKey();
				DLinkedList lowestFreqList = sameFreqMap.get(lowestFreq);
				ListNode lowestFreqLeastRecentlyUsedNode = lowestFreqList.poll();
				if(lowestFreqList.size() == 0) {
					sameFreqMap.remove(lowestFreq);
				}
				kvMap.remove(lowestFreqLeastRecentlyUsedNode.key);				
			}
			ListNode newNode = new ListNode(key,value,1);
			DLinkedList list = sameFreqMap.get(1);
			if(list == null) {
				list = new DLinkedList();
				sameFreqMap.put(1, list);
			}
			list.add(newNode);
			kvMap.put(key, newNode);
		}else {
			v.val = value;
			update(v);
		}
	}
	
	private void update(ListNode node) {
		DLinkedList list = sameFreqMap.get(node.freq);
		list.remove(node);
		if(list.isEmpty()) {
			sameFreqMap.remove(node.freq);
		}
		node.freq++;
		list = sameFreqMap.get(node.freq);
		if(list == null) {
			list = new DLinkedList();
			sameFreqMap.put(node.freq, list);
		}
		list.add(node);
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
