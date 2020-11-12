package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays2 {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> answer = new ArrayList<Integer>();
        int nums1Ptr = 0,nums2Ptr = 0;
        while(nums1Ptr < nums1.length && nums2Ptr < nums2.length) {
        	if(nums1[nums1Ptr] == nums2[nums2Ptr]) {
        		answer.add(nums1[nums1Ptr]);
        		nums1Ptr++;
        		nums2Ptr++;
        	}else if(nums1[nums1Ptr] > nums2[nums2Ptr]) {
        		nums2Ptr++;
        	}else {
        		nums1Ptr++;
        	}
        }
        int[] answerArr = new int[answer.size()];
        int i = 0;
        for(int t : answer) {
        	answerArr[i++] = t;
        }
        return answerArr;
    }

}
