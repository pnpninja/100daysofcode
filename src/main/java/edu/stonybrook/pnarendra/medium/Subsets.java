package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList());
		iterate(res, nums, -1, new ArrayList());

		return res;
	}

	public void iterate(List<List<Integer>> res, int[] nums, int index, List<Integer> li){
		for(int i=index+1; i<nums.length; i++){
			List<Integer> temp = new ArrayList(li);
			temp.add(nums[i]);
			res.add(temp);
			iterate(res, nums, i, temp);
		}
	}
	
	

}
