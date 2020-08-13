package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Databricks_MaximumSequenceAP {
	
	public static void main(String[] args) {
		//int[] a = {0,4,8,16};
		//int[] b = {0,2,6,12,14,20};
		
		int[] a = {5,7,13,14};
		int[] b = {9,11,15};
		
		System.out.println(maxseq(a, b));
	}
	
	public static int maxseq(int[] a, int[] b) {
		int[] arr1 = a;
		int[] arr2 = b;
//	     // copy arrays to main list
//	      List<Integer> ab = new ArrayList<Integer>();
//	      for (int i : a) {
//	         ab.add(i);
//	      }
//	      for (int i : b) {
//	         ab.add(i);
//	      }
//
//	      // sort list in ascending order
//	      Collections.sort(ab);
//
//	      // empty sublist
//	      List<Integer> subList = new ArrayList<Integer>();
//
//	      int start = 0;
//	      for (int i = 2; i < ab.size(); i++) {
//	         // get initial difference
//	         int d = ab.get(start + 1) - ab.get(start);
//	         if (ab.get(i) - ab.get(i - 1) == d) {
//	            // update sublist if difference is same
//	            subList = ab.subList(start, i + 1);
//	         }
//	         else {
//	            // else start anew.
//	            start = i - 1;
//	         }
//	      }
//	      // and return result
//	      System.out.println("*" + subList.toString());
//	      return subList.size() > 2 ? subList.size()
//	            : -1;
		if(arr1.length ==0)return 0;
        int n =arr1.length, m = arr2.length;
        int[] arr = new int[n+m];
        System.arraycopy(arr1,0,arr,0,n);
        System.arraycopy(arr2,0,arr,n,m);
        Arrays.sort(arr);
        int result =0;
        Map<Integer,Integer>d = new HashMap<Integer, Integer>();
//        for(int i =0; i < arr.length;i++){
//            d[i] = new HashMap<Integer, Integer>();
//        }
        for(int i =1; i < arr.length; ++i){
            for(int j = 0; j<i;++j ){
                int diff = arr[i]-arr[j];

                int len =2;

                if(d.containsKey(diff)){
                    len = d.get(diff) +1;
                }



                d.put(diff,len);

                result = Math.max(result,d.get(diff));


            }
        }
        return result;
	   }

}
