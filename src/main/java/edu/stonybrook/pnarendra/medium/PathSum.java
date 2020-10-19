package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
        	return false;
        }else if(root.left == null && root.right == null) {
        	if(root.val == sum) {
        		return true;
        	}else {
        		return false;
        	}
        }else {
        	boolean left = hasPathSum(root.left,sum - root.val);
        	boolean right = hasPathSum(root.right,sum - root.val);
        	return left || right;
        }
    }
}
