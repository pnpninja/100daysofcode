package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }
	
	private boolean isSymmetricHelper(TreeNode left , TreeNode right) {
		if(left == null && right == null) {
			return true;
		}else if(left == null || right == null) {
			return false;
		}else {
			return isSymmetricHelper(left.left, right.right) && 
					isSymmetricHelper(left.right, right.left) && 
					left.val == right.val; 
		}
	}

}
