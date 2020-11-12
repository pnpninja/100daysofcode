package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null) {
        	return root;
        }else {
        	TreeNode left = invertTree(root.left);
        	TreeNode right = invertTree(root.right);
        	TreeNode temp = root.left;
        	root.left = root.right;
        	root.right = temp;
        	return root;
        }
    }

}
