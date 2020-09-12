package edu.stonybrook.pnarendra.solutions;

public class Databricks_CountSawSubarrays {
/*
 * def wiggle(arr):
    i=0
    count = 0
    while i<len(arr)-1:
        if arr[i]<arr[i+1]: up = True
        else: up = False
        j = i
        while j<len(arr)-1:
            if up and arr[j]<arr[j+1]: up = False
            elif up==False and arr[j]>arr[j+1]: up = True
            else:
                break
            j+=1
        if j-i>0:
            n = j-i
            count += (n*(n+1))//2
        i=j if j>i else i+1
    return count

 * 
 */
	
	public int countSawSubarrays(int[] arr) {
		int i = 0, count = 0;
		boolean up = false;
		while(i < arr.length - 1) {
			if(arr[i] < arr[i + 1]) {
				up = true;
			}else {
				up  = false;
			}
			
			int j = i;
			while(j < arr.length - 1) {
				if(up && arr[j] < arr[j + 1]) {
					up = false;
				}else if(!up && arr[j] > arr[j + 1]) {
					up = true;
				}else {
					break;
				}
				j++;
			}
			if(j - i > 0) {
				int n = j - i;
				count += (n*(n+1))/2;
			}
			
			if(j > i) {
				i = j;
			}else {
				i = i + 1;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new Databricks_CountSawSubarrays().countSawSubarrays(new int[] {9,8,7,6,5}));
	}
}
