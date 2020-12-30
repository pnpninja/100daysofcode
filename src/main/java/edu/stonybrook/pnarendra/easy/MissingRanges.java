package edu.stonybrook.pnarendra.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> answer = new ArrayList<String>();
		if(nums.length == 0) {
			addRanges(lower,upper,answer);
		}else {
			if(nums[0] > lower) {
				addRanges(lower, nums[0]-1,answer);
			}
			
			for(int i = 1; i < nums.length;i++) {
				if(nums[i] - nums[i-1] > 1) {
					addRanges(nums[i-1]+1, nums[i]-1,answer);
				}
			}
			if(nums[nums.length-1] < upper ) {
				addRanges(nums[nums.length-1]+1, upper,answer);
			}
			
		}
		return answer;
        
    }
	
	private void addRanges(int start,int end, List<String> answer) {
		 if(start == end) {
			 answer.add(String.valueOf(start));
		 }else {
			 answer.add(String.valueOf(start)+"->"+String.valueOf(end));
		 }
	}

}
