package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 814
// https://leetcode.com/problems/binary-tree-pruning/
public class BinaryTreePruning {
	
	public TreeNode pruneTree(TreeNode root) {
        boolean toPruneRoot = toPrune(root);
        return toPruneRoot ? null : root;
    }
	
	private boolean toPrune(TreeNode root) {
		if(root.left == null && root.right == null) {
			return root.val == 0;
		}else {
			boolean toPruneLeft = root.left == null ? true : toPrune(root.left);
			boolean toPruneRight = root.right == null ? true : toPrune(root.right);
			if(toPruneLeft) {
				root.left = null;
			}
			if(toPruneRight) {
				root.right = null;
			}
			return toPruneLeft && toPruneRight && root.val == 0;
		}
	}

}
