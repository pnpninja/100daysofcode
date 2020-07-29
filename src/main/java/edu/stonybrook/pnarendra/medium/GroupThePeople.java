package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1282
// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class GroupThePeople {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(int index = 0; index < groupSizes.length; index++) {
        	List<Integer> t = map.getOrDefault(groupSizes[index], new ArrayList<Integer>());
        	t.add(index);
        	map.put(groupSizes[index], t);
        }
        for(int size : map.keySet()) {
        	List<Integer> indices = map.get(size);
        	int sizeOfList = indices.size();
        	for(int i = 0; i < sizeOfList/size; i++) {
        		answer.add(indices.subList(i * sizeOfList, (i+1) * sizeOfList));
        	}
        	
        }
        return answer;
        
    }

}
