package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answers = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
        	int target = -nums[i],left = i == 0? 1 : 0,right = i == len - 1 ? len - 2 : len -1;
        	while(left < right) {
        		if(nums[left] + nums[right] == target) {
        			List<Integer> answer = new ArrayList<Integer>();
        			Collections.addAll(answer, nums[left], nums[right],nums[i]);
        			Collections.sort(answer);
        			answers.add(answer);
        		}else if(nums[left] + nums[right] < target) {
        			left++;
        			if(left == i) {
        				left++;
        			}
        		}else {
        			right--;
        			if(right == i) {
        				right--;
        			}
        		}
        	}
        }
        List<List<Integer>> tt = new ArrayList<List<Integer>>();
        for(List<Integer> t : answers) {
        	tt.add(t);
        }
        return tt;
    }
}
