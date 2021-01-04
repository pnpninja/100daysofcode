package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class DiameterOfBinaryTree {
	
	int maxDiameter = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null){
            return 0;
        }
        maxLength(root);
        return maxDiameter - 1;
    }
	
	private int maxLength(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int left = maxLength(root.left);
			int right = maxLength(root.right);
			maxDiameter = Math.max(maxDiameter, left+right+1);
			return Math.max(left, right) + 1;
		}
	}

}
