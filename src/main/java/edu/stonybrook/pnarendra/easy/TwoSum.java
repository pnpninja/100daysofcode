package edu.stonybrook.pnarendra.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1
// https://leetcode.com/problems/two-sum/
public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {

		int dif = 0;
		int oth = 0;
		Map<Integer, Integer> map  = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			dif = target - nums[i];
			if(dif == nums[i]) {
				oth = map.getOrDefault(dif, -1);
				if(oth != -1) {
					return new int[] {oth, i};
				}else {
					map.put(nums[i], i);
				}
			}else {
				oth = map.getOrDefault(dif, -1);
				if(oth != i && oth != -1) {
					return new int[] {map.get(dif), i};
				}else {
					map.put(nums[i], i);
				}
			}
		}
		
		return new int[] {-1,-1};
		
    }

}
