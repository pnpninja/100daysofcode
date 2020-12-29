package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> answers = new HashSet<List<Integer>>();
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> numList = new ArrayList<Integer>();
        for(int num : nums) {
        	numList.add(num);
        }
        backtrack(answer, answers, numList);
        List<List<Integer>> finalAnswer = new ArrayList<List<Integer>>();
        for(List<Integer> x : answers) {
        	finalAnswer.add(x);
        }
        return finalAnswer;
    }
	
	public void backtrack(List<Integer> answer, Set<List<Integer>> answers, List<Integer> numList) {
		if(numList.size()==0) {
			answers.add(new ArrayList<Integer>(answer));
			return;
		}else {
			for(int i = 0; i < numList.size(); i++) {
				int temp = numList.get(i);
				numList.remove(i);
				answer.add(temp);
				backtrack(answer, answers, numList);
				answer.remove(answer.size()-1);
				numList.add(i, temp);
			}
		}
	}
}
