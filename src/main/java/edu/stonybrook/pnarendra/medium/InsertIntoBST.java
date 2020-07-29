package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 701
// https://leetcode.com/problems/insert-into-a-binary-search-tree/

public class InsertIntoBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) {
			root = new TreeNode(val);
			return root;
		}else if(val < root.val) {
			root.left = insertIntoBST(root.left, val);
			return root;
		}else {
			root.right = insertIntoBST(root.right, val);
			return root;
		}
       
    }


}
