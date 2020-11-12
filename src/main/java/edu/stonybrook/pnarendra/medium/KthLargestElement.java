package edu.stonybrook.pnarendra.medium;

public class KthLargestElement {
	
	public int findKthLargest(int[] nums, int k) {
		
		for(int i = nums.length/2; i>= 0; i--) {
			heapify(nums,i,nums.length - 1);
		}
		
		for(int i = 1; i < k; i++) {
			int loc = nums.length - 1 - (k - 1);
			nums[0] = nums[0] + nums[loc];
			nums[loc] = nums[0] - nums[loc];
			nums[0] = nums[0] - nums[loc];
			heapify(nums,0,nums.length - loc);
		}
		return nums[0];
        
    }
	
	private void heapify(int[] nums, int rootIdx, int end) {
		int largest = rootIdx;
		int left = 2*rootIdx + 1;
		int right = 2*rootIdx + 2;
		
		if(left <= end && nums[left] > nums[largest]) {
			largest = left;
		}
		
		if(right <= end && nums[right] > nums[largest]) {
			largest = right;
		}
		
		if(largest != rootIdx) {
			nums[rootIdx] = nums[rootIdx] + nums[largest];
			nums[largest] = nums[rootIdx] - nums[largest];
			nums[rootIdx] = nums[rootIdx] - nums[largest];
			heapify(nums,largest,end);
			
		}
		
	}

}
