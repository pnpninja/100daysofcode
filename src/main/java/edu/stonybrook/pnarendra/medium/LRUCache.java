package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	class ListNode{
		public int val;
		public int key;
		public ListNode next;
		public ListNode prev;
		
	}
	
	Map<Integer, ListNode> map;
	int maxCapacity;
	int currentCapacity;
	ListNode head;
	ListNode tail;
	
	public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currentCapacity = 0;
        this.map = new HashMap<Integer, ListNode>();
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = tail;
        this.tail.prev = head;
       
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
        	return -1;
        }else {
        	ListNode node = map.get(key);
        	deleteFromPosition(node);
        	putAtFirst(node);
        	return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(this.currentCapacity < this.maxCapacity) {
        	ListNode node = new ListNode();
        	node.key = key;
        	node.val = value;
        	if(map.containsKey(key)) {
        		ListNode leastRecentlyUsed = map.get(key);
        		deleteFromPosition(leastRecentlyUsed);
        		this.currentCapacity--;	
        	}
        	putAtFirst(node);
        	map.put(key, node);
        	this.currentCapacity++;
        }else if(this.currentCapacity == this.maxCapacity) {
        	if(map.containsKey(key)) {
        		ListNode leastRecentlyUsed = map.get(key);
        		deleteFromPosition(leastRecentlyUsed);
        		map.remove(key);
        		ListNode node = new ListNode();
            	node.val = value;
            	node.key = key;
            	putAtFirst(node);
            	map.put(key, node);		
        	}else {
        		ListNode leastRecentlyUsed = getLastAccessedNode();
            	deleteFromPosition(leastRecentlyUsed);
            	map.remove(leastRecentlyUsed.key);
            	ListNode node = new ListNode();
            	node.val = value;
            	node.key = key;
            	putAtFirst(node);
            	map.put(key, node);
        	}       	
        }else {
        	
        }
    }
    
    private void putAtFirst(ListNode node) {
    	node.next = head.next;
    	this.head.next.prev = node;
    	node.prev = this.head;
    	this.head.next = node;
    }
    
    private void deleteFromPosition(ListNode node) {
    	node.next.prev = node.prev;
    	node.prev.next = node.next;
    }
    
    private ListNode getLastAccessedNode() {
    	return this.tail.prev;
    }
}
