package edu.stonybrook.pnarendra.medium;
import java.util.List;
import java.util.ArrayList;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> x = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	x.add(nums[i]);
        }
        perform(x,new ArrayList<Integer>(),answers);
        return answers;
    }
	
	private void perform(List<Integer> nums, List<Integer> tempList, List<List<Integer>> answers) {
		if(nums.size() == 0) {
			answers.add(new ArrayList<Integer>(tempList));
			return;
		}
		
		for(int i = 0; i < nums.size(); i++) {
			int t = nums.get(i);
			tempList.add(t);
			nums.remove(i);
			perform(nums, tempList, answers);
			nums.add(i, t);
			tempList.remove(tempList.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Permutations g = new Permutations();
		int[] x = new int[] {1,2,3};
		List<List<Integer>> gg = g.permute(x);
		for(List<Integer> gf : gg) {
			System.out.println(gf.toString());
		}
		System.out.println("Done");
	}

}
