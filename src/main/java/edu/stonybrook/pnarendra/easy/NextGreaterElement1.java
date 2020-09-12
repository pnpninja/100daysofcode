package edu.stonybrook.pnarendra.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElement = new int[nums2.length];
        int pointer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums2.length > 0) {
        	stack.push(nums2[pointer]);
        	pointer = pointer + 1;
        	while(pointer < nums2.length) {
        		if(nums2[pointer] > stack.peek()) {
        			while(!stack.isEmpty() && stack.peek() < nums2[pointer]) {
        				int temp = stack.pop();
        				map.put(temp, nums2[pointer]);
        			}
        			
        		}
        		stack.push(nums2[pointer]);
    			pointer++;
        	}
        }
        
        while(!stack.isEmpty()) {
        	int temp = stack.pop();
        	map.put(temp, -1);
        }
        
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
        	ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
        
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new NextGreaterElement1().nextGreaterElement(new int[] {2,4},new int[]{1,2,3,4})));
	}

}
