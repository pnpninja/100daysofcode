package edu.stonybrook.pnarendra.solutions;

public class Hackerrank_CircularLeftShiftOnString {
	public static int calculate(String result){
		int r = 0;
		char[] arr = result.toCharArray();
		if(arr[0] == arr[arr.length - 1]){
			r++;
		}
		for (int i = 0;i < arr.length-1;i++){
			if(arr[i]==arr[i+1]){
				r++;
			}
		}
		return r;
	}
}
