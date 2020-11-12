package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
		int min  = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for(List<Integer> row : wall) {
			int sum = 0;
			for(int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0)+1);
			}
		}
		for(int width : map.keySet()) {
			min = Math.min(min,wall.size() - map.get(width));
		}
		return min;
        
    }
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(2);
				add(1);
			}
		};
		
		List<Integer> l2 = new ArrayList<Integer>() {
			{
				add(3);
				add(1);
				add(2);
			}
		};
		
		List<Integer> l3 = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
				add(2);
			}
		};
		
		List<Integer> l4 = new ArrayList<Integer>() {
			{
				add(2);
				add(4);
			}
		};
		
		List<Integer> l5 = new ArrayList<Integer>() {
			{
				add(3);
				add(1);
				add(2);
			}
		};
		
		List<Integer> l6 = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
				add(1);
				add(1);
			}
		};
		
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		wall.add(l1);
		wall.add(l2);
		wall.add(l3);
		wall.add(l4);
		wall.add(l5);
		wall.add(l6);
		new BrickWall().leastBricks(wall);
		
	}
	
}
