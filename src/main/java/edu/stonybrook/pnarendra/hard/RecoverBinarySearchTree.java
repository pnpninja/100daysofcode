package edu.stonybrook.pnarendra.hard;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class RecoverBinarySearchTree {
	
	TreeNode min,val1,val2;
	public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = val1.val;
        val1.val = val2.val;
        val2.val = temp;
    }
	
	public void inorderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		inorderTraversal(root.left);
		if(min!= null && root.val < min.val) {
			if(val1 == null) {
				val1 = min;
				val2 = root;
			}else {
				val2= root;
			}
		}
		min = root;
		inorderTraversal(root.right);
	}
}


