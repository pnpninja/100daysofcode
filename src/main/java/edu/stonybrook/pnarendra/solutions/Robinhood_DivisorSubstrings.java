package edu.stonybrook.pnarendra.solutions;

import java.util.HashSet;
import java.util.Set;

public class Robinhood_DivisorSubstrings {
	
	int divisorSubstrings(int n, int k) {
		int count = 0;

	       Set<Integer> set = new HashSet<>();
	       String nStr = String.valueOf(n);
	       for (int i = 0; i <= nStr.length() - k; i++) {
	           int divisor = Integer.parseInt(nStr.substring(i, i + k));
	           if (divisor == 0)
	        		   continue;
	           if (!set.contains(divisor)) {
	               set.add(divisor);
	               if (n % divisor == 0) {
	                   count++;
	               }
	           }
	       }
	       return count;

	}

}
