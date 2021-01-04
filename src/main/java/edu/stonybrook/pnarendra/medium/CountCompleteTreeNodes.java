package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        
        TreeNode left = root.left;
        int left_levels = 1;
        while(left != null) {
        	left = left.left;
        	left_levels++;
        }
        
        TreeNode right = root.right;
        int right_levels = 1;
        while(right != null) {
        	right = right.right;
        	right_levels++;
        }
        
        if(left_levels == right_levels) {
        	return ((int) Math.pow(2, left_levels)) - 1;
        }else {
        	return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
