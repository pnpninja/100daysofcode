package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 763
// https://leetcode.com/problems/partition-labels/
public class StringPartition {
	
	private int maxPos[];
	
	public List<Integer> partitionLabels(String S) {
		List<Integer> answers = new ArrayList<Integer>();
		int endIndex = -1;
		int lastLastIndex = -1;
		int i = 0;
		calculatePositions(S);
		while(i < S.length()) {
			int lastPos = maxPos[S.charAt(i) - 97];
			if(lastPos > endIndex) {
				if(i < lastPos) {
					endIndex = lastPos;
				}else {
					answers.add(i - lastLastIndex);
					lastLastIndex = i;
				}
			}else if(i < endIndex && lastPos <= endIndex) {
				
			}else {
				answers.add(endIndex - lastLastIndex);
				lastLastIndex = endIndex;
				
			}
			i++;
		}
		return answers;
		       
    }	
	
	private void calculatePositions(String s) {
		
		//Initialize arrays
        this.maxPos = new int[26];
        Arrays.fill(this.maxPos, -1); 
        
        
        for(int i = 0; i < s.length(); i++) {
        	if(maxPos[s.charAt(i) - 97] < i) {       		
        		maxPos[s.charAt(i) - 97] = i;
        	}
        }
	}
	
	public static void main(String[] args) {
		List<Integer> temp = new StringPartition().partitionLabels("ababcbacadefegdehijhklij"); //
		System.out.println(temp.toString());
	}

}
