package edu.stonybrook.pnarendra.medium;

public class KthLargestElement2 {
	
	public int findKthLargest(int[] nums, int k) {
		
        if(nums == null || nums.length == 0) {
        	return -1;
        }
        return quickSelect(nums,0,nums.length-1,k);
    }

	
	private int quickSelect(int[] nums, int start, int end, int k) {
		if(start == end) {
			return nums[start];
		}
		
		int pivot = nums[start + ((end - start)/2)];
		int i = start, j = end;
		while(i <= j) {
			while(i <= j && nums[i] > pivot) {
				i++;
			}
			
			while(i <= j && nums[j] < pivot) {
				j--;
			}
			
			if(i<=j) {
				nums[i] = nums[i] + nums[j];
				nums[j] = nums[i] - nums[j];
				nums[i] = nums[i] - nums[j];
				i++;
				j--;
			}
		}
		
		if(start + k - 1 <= j) {
			return quickSelect(nums,start,j,k);
		}
		
		if(start + k - 1 >= i) {
			return quickSelect(nums,i,end,k-(i-start));
		}
		return nums[j+1];
		
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println( new KthLargestElement2().findKthLargest(nums, k));
	}

}
