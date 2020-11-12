package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
	
	class KV{
		int timestamp;
		String value;
        
        public String toString(){
            return "{timestamp = "+timestamp+", value = "+value+"}";
        }
	}
	Map<String,List<KV>> hashmap;
	 /** Initialize your data structure here. */
    public TimeMap() {
         this.hashmap = new HashMap<String,List<KV>>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<KV> temp = this.hashmap.getOrDefault(key, new ArrayList<KV>());
        KV t2 = new KV();
        t2.timestamp = timestamp;
        t2.value = value;
        int locToPut = Collections.binarySearch(temp, t2, new Comparator<KV>() {
			@Override
			public int compare(KV o1, KV o2) {
				return new Integer(o1.timestamp).compareTo(o2.timestamp);
			}
		});
        if(locToPut >= 0) {
        	temp.add(locToPut,t2);
        }else {
        	temp.add(-(locToPut + 1),t2);
        }
        //System.out.println(temp.toString());
        this.hashmap.put(key, temp);
        
    }
    
    public String get(String key, int timestamp) {
    	List<KV> temp = this.hashmap.getOrDefault(key, new ArrayList<KV>());
    	KV t2 = new KV();
        t2.timestamp = timestamp;
        t2.value = null;
    	int locToPut = Collections.binarySearch(temp, t2, new Comparator<KV>() {
			@Override
			public int compare(KV o1, KV o2) {
				return new Integer(o1.timestamp).compareTo(o2.timestamp);
			}
		});
    	if(locToPut >= 0) {
    		return temp.get(locToPut).value;
    	}else {
            int x = locToPut + 1;
            if(x == 0){
                return "";
            }else{
                return temp.get(-(locToPut + 1) - 1).value;
            }
    		
    	}
    }
    
    public static void main(String[] args) {
		TimeMap t = new TimeMap();
		t.set("love", "high", 10);
		t.set("love", "low", 20);
		t.get("love", 5);
		t.get("love", 10);
		t.get("love", 15);
		t.get("love", 20);
		t.get("love", 25);
	}

}
