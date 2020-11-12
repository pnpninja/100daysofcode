package edu.stonybrook.pnarendra.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSumProblem {
	
	static List<List<Integer>> getAllPerfectSum(int[] arr, int sum){
		List<List<Integer>> answers = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		int len = arr.length;
		helper(answers,temp,arr,0,arr.length,sum);
		return answers;
		
	}
	
	static void helper(List<List<Integer>> answers, List<Integer> temp, int[] arr, int idx, int len, int sum) {
		if(temp.stream().mapToInt(Integer::intValue).sum() == sum){
			answers.add(new ArrayList<Integer>(temp));
		}
		
		for(int j = idx; j < len; j++) {
			temp.add(arr[j]);
			helper(answers, temp, arr, j + 1, len, sum);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int sum = 10;
		List<List<Integer>> answers = getAllPerfectSum(arr, sum);
		System.out.println(answers.toString());
		
	}

}
