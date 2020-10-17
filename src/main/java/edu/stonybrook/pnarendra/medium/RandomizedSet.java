package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	Map<Integer, Integer> map;
	List<Integer> list;
	Random rand;
	
	/** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        //First find index
        int idx = map.get(val);
        //if last element in list, just straight up remove
        if(idx == list.size() - 1) {
        	list.remove(idx);
        	map.remove(val);
        }else {
        	list.remove(idx);
        	int vv = list.get(list.size() - 1);
        	list.remove(list.size() - 1);
        	map.put(vv, idx);
        	list.add(idx,vv);
        	map.remove(val);
        }
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
