package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 104
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class BinaryTreeMaxDepth {
	
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			return 1 + (left > right ? left : right);
		}
	}
}
