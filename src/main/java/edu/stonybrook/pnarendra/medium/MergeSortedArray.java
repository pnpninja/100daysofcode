package edu.stonybrook.pnarendra.medium;

public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(n == 0){
            return;
        }else if(m == 0) {
        	for(int i = 0; i < Math.min(nums1.length, nums2.length); i++){
                nums1[i] = nums2[i];
            }
        	return;
        }
        int nums1Index = m - 1, nums2Index = n - 1, iter = m + n - 1, temp;
        while(iter >= 0) {
        	if(nums2Index < 0) {
        		nums1[iter--] = nums1[nums1Index--];
        	}else if(nums1Index < 0) {
        		nums1[iter--] = nums2[nums2Index--];
        	}else {
        		if(nums2[nums2Index] > nums1[nums1Index]) {
            		nums1[iter--] = nums2[nums2Index--];
            	}else {
            		nums1[iter--] = nums1[nums1Index--];
            	}
        	}
        	
        }
        
    }

}
