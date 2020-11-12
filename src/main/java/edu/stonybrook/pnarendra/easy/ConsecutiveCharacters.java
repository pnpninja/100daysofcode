package edu.stonybrook.pnarendra.easy;

public class ConsecutiveCharacters {
	
	public int maxPower(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		char[] arr = s.toCharArray();
		int ans = 1;
		int i = 0;
		while(i < arr.length) {
			int j = i;
			while(j < arr.length && arr[j] == arr[i]) {
				j++;
			}
			ans = Math.max(ans, j - i + 1);
			i = j;
		}
		return ans;
	}

}
