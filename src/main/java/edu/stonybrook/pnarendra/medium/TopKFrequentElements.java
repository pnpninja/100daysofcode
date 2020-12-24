package edu.stonybrook.pnarendra.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MyObject{
	int key;
	int count;
	
	public MyObject(int key) {
		this.key = key;
		this.count = 1;
	}
}

class MyObject2{
	int key;
	int count;
	boolean inHeap;
	
	public MyObject2(int key) {
		this.key = key;
		this.count = 1;
		this.inHeap = false;
	}
}
public class TopKFrequentElements {
	
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,MyObject> map = new HashMap<>();
        PriorityQueue<MyObject> pq = new PriorityQueue<>(new Comparator<MyObject>() {

			@Override
			public int compare(MyObject o1, MyObject o2) {
				return new Integer(o2.count).compareTo(o1.count);
			}
        	
        });
        for(int num : nums) {
        	if(map.containsKey(num)) {
        		MyObject temp = map.get(num);
        		pq.remove(temp);
        		temp.count++;
        		pq.add(temp);
        	}else {
        		MyObject temp = new MyObject(num);
        		map.put(num, temp);
        		pq.add(temp);
        	}
        }
        int ansSize = Math.min(k, pq.size());
        int[] answer = new int[ansSize];
        int i = 0;
        while(i < ansSize) {
        	MyObject t = pq.poll();
        	answer[i] = t.key;
        	i++;
        }
        return answer;
        
    }
	
	public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,MyObject> map = new HashMap<>();
        PriorityQueue<MyObject> pq = new PriorityQueue<>(new Comparator<MyObject>() {

			@Override
			public int compare(MyObject o1, MyObject o2) {
				return new Integer(o1.count).compareTo(o2.count);
			}
        	
        });
        
        for(int num : nums) {
        	if(!map.containsKey(num)) {
        		MyObject newObj = new MyObject(num);
        		map.put(num, newObj);
        		if(pq.size() < k) {
        			pq.add(newObj);
        		}else {
        			MyObject minEle = pq.peek();
        			if(newObj.count > minEle.count) {
        				pq.poll();
        				pq.add(newObj);
        			}
        		}
        	}else {
        		MyObject newObj = map.get(num);
        		newObj.count++;
        	}
        }
   
        
    }

}
