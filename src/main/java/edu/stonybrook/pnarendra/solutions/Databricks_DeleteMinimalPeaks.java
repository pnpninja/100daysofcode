package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.List;

public class Databricks_DeleteMinimalPeaks {
	
	List<Integer> deletedPeaks;
	int minimalPosition = -1;
	int minimalPeak = Integer.MAX_VALUE;
	

	
	public List<Integer> deleteMinimalPeaks(int[] numbers) {
		this.deletedPeaks = new ArrayList<Integer>();
		List<Integer> nnumbers = new ArrayList<Integer>();
		for(int number : numbers) {
			nnumbers.add(number);
		}
		int iters = nnumbers.size();
		for(int i = 0; i < iters - 1; i++) {
			nnumbers = deleteMinimalPeak(nnumbers);
		}
		if(nnumbers.size() == 1) {
			deletedPeaks.add(nnumbers.get(0));
		}		
		return deletedPeaks;		
	}
	
	private List<Integer> deleteMinimalPeak(List<Integer> numbers){
		int minimalPosition = -1;
		int minimalPeak = Integer.MAX_VALUE;
		for(int i = 0; i < numbers.size(); i++) {
			if(isPeak(numbers,i)) {
				if(numbers.get(i) < minimalPeak) {
					minimalPeak = numbers.get(i);
					minimalPosition = i;
				}
			}
		}
		deletedPeaks.add(numbers.get(minimalPosition));
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < numbers.size(); i++) {
			if(i != minimalPosition) {
				temp.add(numbers.get(i));
			}
		}
		return temp;
		
		
	}
	
	private boolean isPeak(List<Integer> numbers, int index) {
		if(index == 0) {
			if(numbers.get(index) > numbers.get(index + 1)) {
				return true;
			}else {
				return false;
			}
		}else if(index == numbers.size() - 1) {
			if(numbers.get(index) > numbers.get(index - 1)) {
				return true;
			}else {
				return false;
			}
		}else {
			if(numbers.get(index) > numbers.get(index - 1) && numbers.get(index) > numbers.get(index + 1)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Databricks_DeleteMinimalPeaks().deleteMinimalPeaks(new int[] {2,7,8,5,1,6,3,9,4}).toString());
	}

}
