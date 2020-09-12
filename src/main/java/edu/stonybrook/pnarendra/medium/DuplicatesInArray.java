package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
	
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<Integer>();
        for(int i = 0 ;i < nums.length; i++) {
        	if(nums[Math.abs(nums[i]) - 1] < 0) {
        		answer.add(Math.abs(nums[i]));
        	}
        	nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
        }
        return answer;
    }

}
