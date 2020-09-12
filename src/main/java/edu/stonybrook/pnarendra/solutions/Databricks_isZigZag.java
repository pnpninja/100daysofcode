package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.List;

public class Databricks_isZigZag {
	
	public int[] isZigzag(int[] arr) {
		List<Integer> isZigzag = new ArrayList<Integer>();
		for(int i = 1; i < arr.length - 1; i++) {
			isZigzag.add(isZigZagHelper(arr[i - 1],arr[i], arr[i+1]) ? 1 : 0);
		}
		
		int[] arr2 = new int[isZigzag.size()];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = isZigzag.get(i);
		}
		return arr2;
	}
	
	private boolean isZigZagHelper(int left, int mid, int right) {
		if(left < mid && mid > right) {
			return true;
		}else if(left > mid && mid < right) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Databricks_isZigZag().isZigzag(new int[] {1,2,3,4}));
	}

}
