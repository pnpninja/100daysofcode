package edu.stonybrook.pnarendra.solutions;

import java.util.Collections;
import java.util.List;

public class Hackerrank_FindDolls {
	public int findDolls(List<Integer> size) {
		Collections.sort(size);
		int len = size.size();
		int l = size.size()/2 - 1, h = size.size() - 1, r = size.size();
		while(l >= 0 && h >= len/2 ){
			if(size.get(h) >= 2*size.get(l)){
				l-- ; 
				h--;
				r--;
			}else{
				l--;
			}
		}
		return r;
	}
}
