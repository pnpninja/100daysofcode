package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Amazon_FirstXTopK {
	class Datum{
		public int num;
		public int count;
		public int firstIndex;
	}
	List<Integer> firstXTopk(int[] nums, int x){
		HashMap<Integer, Datum> map = new HashMap<Integer, Datum>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				Datum obj = map.get(nums[i]);
				obj.count++;
				map.put(nums[i], obj);
			}else {
				Datum obj = new Datum();
				obj.num = nums[i];
				obj.firstIndex = i;
				obj.count++;
				map.put(nums[i], obj);
			}
		}
		
		List<Datum> temp = map.values().stream().filter(obj -> obj.count == x).collect(Collectors.toList());
		temp.sort((a,b) -> a.firstIndex -b.firstIndex);
		List<Integer> answer = new ArrayList<Integer>();
		for(Datum item : temp) {
			answer.add(item.num);
		}
		return answer;
	}
}
