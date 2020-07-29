package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 654
// https://leetcode.com/problems/maximum-binary-tree/submissions/
public class ConstructMaximumBinaryTree {
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length == 0) {
        	return null;
        }else if(nums.length == 1) {
        	return new TreeNode(nums[0]);        	
        }else {
        	int max = Integer.MIN_VALUE;
        	int maxIndex = -1;
        	for(int i = 0; i < nums.length; i++) {
        		if(nums[i] > max) {
        			max = nums[i];
        			maxIndex = i;
        		}
        	}
        	TreeNode root = new TreeNode(nums[maxIndex]);
        	root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        	root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        	return root;
        }
    }

}
