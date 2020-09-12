package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 451
// https://leetcode.com/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency {
	class MyObject{
		public char character;
		public int count;
		
		public MyObject(char character) {
			this.character = character;
			this.count = 0;
		}
		
	}
	
	public String frequencySort(String s) {
        Map<Character, MyObject> map = new HashMap<Character, MyObject>();
        for (char c : s.toCharArray()){
        	MyObject temp = map.getOrDefault(c, new MyObject(c));
        	temp.count++;
        	map.put(c, temp);
        }
        
        List<MyObject> temp = new ArrayList<MyObject>(map.values());
        Collections.sort(temp, (a,b) -> a.count - b.count);
        StringBuilder answer = new StringBuilder("");
        for(MyObject x : temp) {
        	processMapEntry(answer, x);
        }
        
        return answer.reverse().toString();
               
        
    }
	
	private void processMapEntry(StringBuilder answer, MyObject obj) {
		for(int i = 0; i < obj.count; i++) {
			answer.append(obj.character);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new SortCharactersByFrequency().frequencySort("raaeaedere"));
	}

}
