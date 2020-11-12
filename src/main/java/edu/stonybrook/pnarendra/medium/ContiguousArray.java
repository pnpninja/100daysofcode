package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length;i++) {
        	if(nums[i] == 0) {
        		nums[i] = -1;
        	}
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	sum+=nums[i];
        	if(sum == 0) {
        		maxLen = i+1;
        	}else {
        		if(hm.containsKey(sum)) {
        			maxLen = Math.max(maxLen, i - hm.get(sum));
        		}else {
        			hm.put(sum, i);
        		}
        	}
        }
        return maxLen;
    }

}
