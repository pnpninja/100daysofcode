package edu.stonybrook.pnarendra.hard;

public class TrappingRainWater {
	
	public int trap(int[] height) {
        int leftMax = 0, 
        		rightMax = 0, 
        		left = 0, 
        		right = height.length - 1, 
        		result = 0;
       while(left <= right) {
    	   
    	   if(height[left] < height[right]) {
    		   if(height[left] > leftMax) {
    			   leftMax = height[left];
    		   }else {
    			   result+= leftMax - height[left];
    		   }
    		   left++;
    	   }else {
    		   if(height[right] > rightMax) {
    			   rightMax = height[right];
    		   }else {
    			   result+= rightMax - height[right];
    		   }
    		   right--;
    	   }
    	   
       }
       return result;
    }

}
